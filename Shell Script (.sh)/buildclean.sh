#!/bin/bash
#
#

ubuntu=gutsy
argc=$#
script=`basename $0`

if ! (uname -a | grep -q Linux )
then
    echo "${script} is meant for Linux systems only, not" `uname -s`
    exit
fi

if [ ${argc} -lt 2 ]
then
    echo "${script}: Too few arguments"
    echo "Syntax: ${script} <servernumber> <buildtag> [mysqlpasswd]"
    exit
fi

ws=/tmp/$$
# extract and clean up server number
servernumber=$1
servername=`awk "BEGIN {printf(\"%04d\", $1)}" </dev/null`
# build up the subversion repository URL from the build tag
svnrelease=$2
svncredentials="--username=vsadmin --password=vsadmin07"
svnargs="${svncredentials}"
export SVNPATH="http://voip.svn.victorysite.us/version1/${svnrelease}/"

# check to see if this is the real deal run
uptodate=0
if [ "$3" = "therealdeal" ]; then
    uptodate=1
fi

# optionally override the mysql password for the root user
mysqlpasswd="gs.7v_x"
if [ ${argc} -gt 3 ]; then
    mysqlpasswd="$4"
else
    if [ ${uptodate} -eq 0 ]; then
    	if [ \! -z "$3" ]; then
    		mysqlpasswd="$3"
    	fi
    fi
fi

echo $SVNPATH
echo -n "Building server vv${servername} from release ${svnrelease}"

# Force download of latest version of this script from subversion...
# but of course that does mean we need subversion installed...
if [ \! -e /usr/bin/svn ] ; then
    apt-get install -y subversion
fi
if [ ${uptodate} -eq 0 ]; then
    echo ", but first updating buildclean.sh; just in case"
    mkdir ${ws}
    cp buildclean.sh ${ws}
    cd ${ws}
    cp buildclean.sh ${ws}
    if [ $? -ne 0 ] || [ ! -f ${ws}/${script} ]; then
         echo "build instructions for SVN release tag ${svnrelease} found"
    mkdir ${ws}
    cp buildclean.sh ${ws}
    cd ${ws}

    fi

    chmod +x ${ws}/${script}
    exec ${ws}/${script} ${servernumber} ${svnrelease} therealdeal ${mysqlpasswd}
else
    echo ", for real this time!"
fi

# Create the vsadmin user if it doesn't exist yet and set the password
if grep -q vsadmin /etc/passwd; then
    adduser vsadmin --quiet --gecos "" --disabled-password
fi
usermod -a -G admin vsadmin
passwd vsadmin <<EOT
gs.7v_x
gs.7v_x
EOT

cd /home/vsadmin

#
# Force the (new) hostname onto this system
echo vv${servername} >/etc/hostname
cat <<EOT >/etc/hosts
127.0.0.1	localhost
127.0.1.1	vv${servername}

# The following lines are desirable for IPv6 capable hosts
::1     ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
ff02::
 ip6-allhosts
EOT

#
# This section should really somehow be conditional on the version of
# Ubuntu we find ourselves on...
if [ ${ubuntu} = "gutsy" ]
then
    # Start by getting the full complement of repositories for our Gutsy
    # distribution in place:
    #	1) replace default list because gutsy is no longer supported
    #	2) add backports for newer packages
    cat > /etc/apt/sources.list <<EOT
    #
    #
    #
    #
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy main restricted
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-updates main restricted
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy universe
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-updates universe
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy multiverse
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-updates multiverse
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-security main restricted
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-security universe
    deb http://old-releases.ubuntu.com/ubuntu/ gutsy-security multiverse

            
EOT
    cat > /etc/apt/sources.list.d/gutsy-backports.list <<EOT
    deb http://old-releases.ubuntu.com/ubuntu gutsy-backports main universe multiverse restricted
EOT
fi

#
# Disable the automatic use of fsck on every "n" reboots, and also make it so that when
# a reboot does require a fsck, all prompts will be answered "yes" by default
tune2fs -c 0 /dev/sda1
sed -i -e 's/^FSCKFIX=no/FSCKFIX=yes/' /etc/default/rsS
apt-get update
apt-get upgrade -y
apt-get install -y linux-headers-`uname -r`
apt-get install -y ddclient dhcp3-server dnsmasq dpkg gcc g++ gzip traceroute zlib1g-dev libssl-dev \
    libnewt-dev rdate make autossh screen unixodbc-dev ntp sox shorewall
apt-get install -y ncurses-dev libncurses5-dev
apt-get install -y openbsd-inetd tftpd
apt-get install -y mysql-server mysql-client libmysqlclient15-dev
apt-get install -y php5 php5-mysql php5-cli
apt-get install -y patch

echo "Installing SVN release ${svnrelease} on server ${servernumber}"

cd /home/vsadmin
for d in code configurations distributions administration; do
    if [ -d $d/.svn ] ; then
        r=`svn info $d | awk -F/ '/^URL/ {print $5}'`
        if [ "$r" = ${svnrelease} ] ; then
            # Looks like we stand a chance just updating this directory but first clean it up
            echo -n "Updating $d "
            svn cleanup $d
            svn update $d
            continue
        fi
    fi
    echo "Checking out $d"
    rm -rf $d
    svn checkout ${SVNPATH}/$d ${svnargs}
done

mkdir /usr/local/etc/vv
cp /home/vsadmin/administration/etc/*.conf /usr/local/etc/vv/
cp /home/vsadmin/administration/take-snap.pl /usr/local/bin/take-snap.pl

# Remove unwanted network driver from CE units
if grep -q Atom /proc/cpuinfo ; then
    /etc/cron.daily/find
    rm -rf `locate r8169`
    depmod -a
    update-initramfs -u -v
fi

# Hardwire internal interface to 192.168.50.1 and leave external as DHCP client simply
# replacing the interfaces file
cd /home/vsadmin/configurations/network/
cp interfaces /etc/network/interfaces
/etc/init.d/networking restart

# DHCP client and server configurations
cd /home/vsadmin/configurations
cp -p dhclient.conf dhcpd.conf /etc/dhcp3 && chmod a+r /etc/dhcp3/*.conf && /etc/init.d/dhcp3-server restart

# DNS caching
cp dnsmasq.conf /etc/dnsmasq.conf

cd /home/vsadmin/configurations/ddclient
sed -e "s/vvNNNN/vv${servername}/" <ddclient-inside.conf >/etc/ddclient-inside.conf
sed -e "s/vvNNNN/vv${servername}/" <ddclient-outside.conf >/etc/ddclient-outside.conf
sed -i -e 's/run_daemon[\s]*=[\s]*"false"/run_daemon="true"/' /etc/default/ddclient 
rm /etc/ddclient.conf
ln /etc/ddclient-outside.conf /etc/ddclient.conf
cp ddclient-inside /etc/init.d
ln /usr/sbin/ddclient /usr/sbin/ddclient-inside
update-rc.d ddclient-inside defaults
/etc/init.d/ddclient start
/etc/init.d/ddclient-inside start

# Install the tunnel servers' certificates
bash /home/vsadmin/distributions/reverse-ssh/tunsetup.sh

mkdir /tftpboot
sed -i -e '/in.tftpd/d' /etc/inetd.conf
cat >>/etc/inetd.conf <<EOT
tftp            dgram   udp     wait    nobody  /usr/sbin/tcpd  /usr/sbin/in.tftpd /tftpboot
EOT
cd /home/vsadmin/configurations/tftpboot
chown nobody:nogroup /tftpboot
chmod a+rwx /tftpboot
cp aastra.cfg 57i.st /tftpboot
chmod a+rw /tftpboot/aastra.cfg
chmod a+rw /tftpboot/57i.st

cd /home/vsadmin/configurations/shorewall
cp * /etc/shorewall/
rm -f /etc/rc*d/*shorewall
update-rc.d shorewall defaults
sed -i -e 's/startup=0/startup=1/' /etc/default/shorewall
shorewall restart

/etc/init.d/ntp stop
ntpdate ntp.ubuntu.com
/etc/init.d/ntp start
date

#
# Create the wwwVictoryVoip and asterisk databases
cd /home/vsadmin/configurations/mysql/
cat <<EOT | mysql --password="${mysqlpasswd}"
CREATE USER 'vsadmin'@'localhost' IDENTIFIED BY 'gs.7v_x';
EOT
mysqladmin --password="${mysqlpasswd}" create wwwVictoryVoip
mysqladmin --password="${mysqlpasswd}" create asterisk
mysql --password="${mysqlpasswd}" wwwVictoryVoip <wwwVictoryVoip.sql
mysql --password="${mysqlpasswd}" wwwVictoryVoip <wwwVictoryVoip-Views.sql
mysql --password="${mysqlpasswd}" wwwVictoryVoip <wwwVictoryVoip-StoredProcedures.sql
mysql --password="${mysqlpasswd}" wwwVictoryVoip <wwwVictoryVoip-Grants.sql
mysql --password="${mysqlpasswd}" asterisk <asterisk.sql
mysql --password="${mysqlpasswd}" asterisk <asterisk-Grants.sql

#
# Asterisk and dahdi compiling and installations
if [ -f /etc/init.d/asterisk ]
then
    /etc/init.d/asterisk stop
fi
cd ~vsadmin/distributions/
chown vsadmin:vsadmin .
su vsadmin -c "tar zxf dahdi-linux-complete-2.4.1.2+2.4.1.tar.gz"
cd dahdi-linux-complete-2.4.1.2+2.4.1/
sed -i -e 's/^#obj-$(DAHDI_BUILD_ALL)/obj-$(DAHDI_BUILD_ALL)/' linux/drivers/dahdi/Kbuild 
su vsadmin -c "make all"
make install
make config
modprobe dahdi_dummy
./dahdi_cfg -vv

cd ~vsadmin/distributions
su vsadmin -c "tar zxf asterisk-1.4.41.2.tar.gz"
cd asterisk-1.4.41.2/
su vsadmin -c "patch res/res_features.c <../res_features.bridged-call.patch"
su vsadmin -c "patch  contrib/scripts/safe_asterisk <../safe_asterisk.patch"
su vsadmin -c ./configure
su vsadmin -c make
make install
# remove remnants of zaptel; just in case...
sed -i -e '/ztdummy/d' -i  /etc/modules

su vsadmin -c "tar -zxf asterisk-addons-1.4.6.tar.gz"
cd /home/vsadmin/distributions/asterisk-addons-1.4.6
su vsadmin /configure
make install
# Copy the g729 codec into place
cd /home/vsadmin/distributions/g729
cp -p codec_g729.so /usr/lib/asterisk/modules

#
# Update sample asterisk configuration files with the production set and make sure that all production
# configuration files and directories are owned by www-data so the webserver can update them
cd /home/vsadmin/configurations
cp -R asterisk/ /etc/
mkdir /etc/asterisk/robocall-campaigns
chown -R www-data.www-data /etc/asterisk
# And make sure asterisk is started at boot
cd /home/vsadmin/distributions
cp -p init.d/asterisk /etc/init.d/asterisk
update-rc.d asterisk defaults

cd /home/vsadmin/configurations/sounds
cp *.g729 /var/lib/asterisk/sounds

mkdir /var/lib/asterisk/vv /var/lib/asterisk/vv/recordings /var/lib/asterisk/vv/robocalls /var/lib/asterisk/vv/vm
chown -R www-data.www-data /var/lib/asterisk/vv

#/home/vsadmin/administration/setproviders.sh ${servernumber}
#/home/vsadmin/administration/genproviders.pl

cat <<EOT
EDIT THIS FILE BY ADDING THE PROPER PASSWORD TO VIP, CHANGE THE SERVER FROM 5 TO EITHER 3 OR 4............
EDIT VOXITAS BY ADDING THE RIGHT SERVER NUMBER AND CHANGING THE HOST TO THE PROPER SERVER, MAKE SURE SRV IS ENABLED.............................

nano /etc/asterisk/iax.conf
EOT
read

cat <<EOT
EDIT VIP AND MAKE SURE VOXITAS IS THE MAIN PROVIDER

nano /etc/asterisk/vv_extensions.conf
EOT
read


# Start asterisk
/etc/init.d/asterisk start
asterisk -rx "iax2 show peers"

#
# Make sure that apache can invoke asterisk via sudo
if ! grep -q /usr/sbin/asterisk /etc/sudoers;
then
    echo www-data ALL = NOPASSWD: /usr/sbin/asterisk >>/etc/sudoers
fi

#
# Get the backup snapshot folder created
mkdir /var/spool/vv
chown vsadmin:vsadmin /var/spool/vv

#
# install the web site sources
mkdir /var/www/vs
cd /home/vsadmin/code
tar --exclude=.svn --exclude=CVS -cf - admin asterisk aastra phone-config *.php | (cd /var/www/vs; tar xf -)
# and enforce the access rights
cd /var/www/vs/
chown -R www-data:www-data *
chmod 644 *.php */*.php
chmod 644 admin/images/*.png
chmod 755 admin/js/*.js
chmod 444 *.ico images/*.png

#
# Configure the website
cd /home/vsadmin/configurations/apache2/
cp ports.conf /etc/apache2/ports.conf
cp sites-enabled/000-default /etc/apache2/sites-enabled/000-default
cd /etc/apache2/mods-enabled/
ln -s ../mods-available/proxy.load
ln -s ../mods-available/proxy_http.load
apache2ctl restart

#
# Need newer version of sox for proper audio format conversions to work right
(
libsoxfmtmp3="14.3.1-1_i386"
cd /tmp &&
wget http://ftp.us.debian.org/debian/pool/main/s/sox/libsox-fmt-mp3_${libsoxfmtmp3}.deb &&
dpkg -i libsox-fmt-mp3_${libsoxfmtmp3}.deb;
)

#
# Puppet won't install properly unless the bare hostname "puppet" resolves to a machine configured as the
# puppetmaster.  VS operates a puppetmaster at puppet.victorysite.us  However, the machine where this
# installation is running is likely not to have victorysite.us in its DNS search path: make it so
if [ \! -e /usr/sbin/puppetd ] ; then
    apt-get remove -y puppet
    sed -i -e '/^[ ]*search.*/d' /etc/resolv.conf
    cat <<EOT >>/etc/resolv.conf
search victorysite.us
EOT
    apt-get install -y puppet
fi
/etc/init.d/puppet start
echo "Please make sure the puppet client certificate for this machine is signed with:"
echo "	puppetca -s vv${servernumber}.victorysite.us"
