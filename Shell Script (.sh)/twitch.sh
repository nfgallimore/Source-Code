#!/bin/bash

video_dir=~/twitch

if [ $# -ne 1 ]; then
        echo "Usage: $0 twitch_video_id"
        exit 0
fi

id=$1
video_urls=( $(curl http://api.justin.tv/api/broadcast/by_archive/${id}.xml?onsite=true | grep video_file_url | sed 's/.*url>\(http:.*\)< \/vid.*/\1/') )

if [ ! -d $video_dir ]; then
        mkdir $video_dir
fi

cd $video_dir

# download the videos
for i in ${video_urls[*]}; do
        wget -c $i
done

rm -f int*.ts
concat_list='concat:'
last_num=${#video_urls[*]}
let last_num--

# convert the videos to Mpeg TS video format
for i in $( seq 0 $last_num ); do
        ffmpeg -i ${video_urls[$i]/*\//} -c copy -bsf:v h264_mp4toannexb -f mpegts int${i}.ts
        if [ "$i" -eq 0 ]; then
                concat_list="${concat_list}int${i}.ts"
        else
                concat_list="$concat_list|int${i}.ts"
        fi
done

# merge the files togather
ffmpeg -f mpegts -i "$concat_list" -c copy for_youtube_${id}.flv