/*!
	Colorbox v1.4.27 - 2013-07-16
	jQuery lightbox and modal window plugin
	(c) 2013 Jack Moore - http://www.jacklmoore.com/colorbox
	license: http://www.opensource.org/licenses/mit-license.php
*/
!function(a,b,c){function db(c,d,e){var g=b.createElement(c);return d&&(g.id=f+d),e&&(g.style.cssText=e),a(g)}function eb(){return c.innerHeight?c.innerHeight:a(c).height()}function fb(a){var b=v.length,c=(S+a)%b;return 0>c?b+c:c}function gb(a,b){return Math.round((/%/.test(a)?("x"===b?w.width():eb())/100:1)*parseInt(a,10))}function hb(a,b){return a.photo||a.photoRegex.test(b)}function ib(a,b){return a.retinaUrl&&c.devicePixelRatio>1?b.replace(a.photoRegex,a.retinaSuffix):b}function jb(a){"contains"in o[0]&&!o[0].contains(a.target)&&(a.stopPropagation(),o.focus())}function kb(){var b,c=a.data(R,e);null==c?(M=a.extend({},d),console&&console.log&&console.log("Error: cboxElement missing settings object")):M=a.extend({},c);for(b in M)a.isFunction(M[b])&&"on"!==b.slice(0,2)&&(M[b]=M[b].call(R));M.rel=M.rel||R.rel||a(R).data("rel")||"nofollow",M.href=M.href||a(R).attr("href"),M.title=M.title||R.title,"string"==typeof M.href&&(M.href=a.trim(M.href))}function lb(c,d){a(b).trigger(c),L.trigger(c),a.isFunction(d)&&d.call(R)}function nb(c){X||(R=c,kb(),v=a(R),S=0,"nofollow"!==M.rel&&(v=a("."+g).filter(function(){var c,b=a.data(this,e);return b&&(c=a(this).data("rel")||b.rel||this.rel),c===M.rel}),S=v.index(R),-1===S&&(v=v.add(R),S=v.length-1)),n.css({opacity:parseFloat(M.opacity),cursor:M.overlayClose?"pointer":"auto",visibility:"visible"}).show(),_&&o.add(n).removeClass(_),M.className&&o.add(n).addClass(M.className),_=M.className,M.closeButton?I.html(M.close).appendTo(q):I.appendTo("<div/>"),V||(V=W=!0,o.css({visibility:"hidden",display:"block"}),x=db($,"LoadedContent","width:0; height:0; overflow:hidden"),q.css({width:"",height:""}).append(x),N=r.height()+u.height()+q.outerHeight(!0)-q.height(),O=s.width()+t.width()+q.outerWidth(!0)-q.width(),P=x.outerHeight(!0),Q=x.outerWidth(!0),M.w=gb(M.initialWidth,"x"),M.h=gb(M.initialHeight,"y"),Z.position(),lb(h,M.onOpen),K.add(A).hide(),o.focus(),M.trapFocus&&b.addEventListener&&(b.addEventListener("focus",jb,!0),L.one(l,function(){b.removeEventListener("focus",jb,!0)})),M.returnFocus&&L.one(l,function(){a(R).focus()})),qb())}function ob(){!o&&b.body&&(cb=!1,w=a(c),o=db($).attr({id:e,"class":a.support.opacity===!1?f+"IE":"",role:"dialog",tabindex:"-1"}).hide(),n=db($,"Overlay").hide(),z=a([db($,"LoadingOverlay")[0],db($,"LoadingGraphic")[0]]),p=db($,"Wrapper"),q=db($,"Content").append(A=db($,"Title"),B=db($,"Current"),E=a('<button type="button"/>').attr({id:f+"Previous"}),D=a('<button type="button"/>').attr({id:f+"Next"}),F=a('<button type="button"/>').attr({id:f+"RotateLeft"}),G=a('<button type="button"/>').attr({id:f+"RotateRight"}),H=a('<button type="button"/>').attr({id:f+"Zoom"+U.zoom}),C=db("button","Slideshow"),z),I=a('<button type="button"/>').attr({id:f+"Close"}),p.append(db($).append(db($,"TopLeft"),r=db($,"TopCenter"),db($,"TopRight")),db($,!1,"clear:left").append(s=db($,"MiddleLeft"),q,t=db($,"MiddleRight")),db($,!1,"clear:left").append(db($,"BottomLeft"),u=db($,"BottomCenter"),db($,"BottomRight"))).find("div div").css({"float":"left"}),y=db($,!1,"position:absolute; width:9999px; visibility:hidden; display:none"),J=F.add(G),K=D.add(E).add(B).add(C),a(b.body).append(n,o.append(p,y)))}function pb(){function c(a){a.which>1||a.shiftKey||a.altKey||a.metaKey||a.ctrlKey||(a.preventDefault(),nb(this))}return o?(cb||(cb=!0,D.click(function(){Z.next()}),E.click(function(){Z.prev()}),F.click(function(){Z.rotateLeft()}),G.click(function(){Z.rotateRight()}),H.click(function(){Z.zoom()}),I.click(function(){Z.close()}),n.click(function(){M.overlayClose&&Z.close()}),a(b).bind("keydown."+f,function(a){var b=a.keyCode;V&&M.escKey&&27===b&&(a.preventDefault(),Z.close()),V&&M.arrowKey&&v[1]&&!a.altKey&&(37===b?(a.preventDefault(),E.click()):39===b&&(a.preventDefault(),D.click()))}),a.isFunction(a.fn.on)?a(b).on("click."+f,"."+g,c):a("."+g).live("click."+f,c)),!0):!1}function qb(){var d,e,h,g=Z.prep,j=++ab;W=!0,T=!1,R=v[S],kb(),lb(m),lb(i,M.onLoad),M.h=M.height?gb(M.height,"y")-P-N:M.innerHeight&&gb(M.innerHeight,"y"),M.w=M.width?gb(M.width,"x")-Q-O:M.innerWidth&&gb(M.innerWidth,"x"),M.mw=M.w,M.mh=M.h,M.maxWidth&&(M.mw=gb(M.maxWidth,"x")-Q-O,M.mw=M.w&&M.w<M.mw?M.w:M.mw),M.maxHeight&&(M.mh=gb(M.maxHeight,"y")-P-N,M.mh=M.h&&M.h<M.mh?M.h:M.mh),d=M.href,Y=setTimeout(function(){z.show()},100),M.inline?(h=db($).hide().insertBefore(a(d)[0]),L.one(m,function(){h.replaceWith(x.children())}),g(a(d))):M.iframe?g(" "):M.html?g(M.html):hb(M,d)?(d=ib(M,d),T=b.createElement("img"),a(T).addClass(f+"Photo").bind("error",function(){M.title=!1,g(db($,"Error").html(M.imgError))}).one("load",function(){var b;j===ab&&(T.alt=a(R).attr("alt")||a(R).attr("data-alt")||"",M.retinaImage&&c.devicePixelRatio>1&&(T.height=T.height/c.devicePixelRatio,T.width=T.width/c.devicePixelRatio),M.scalePhotos&&(e=function(){T.height-=T.height*b,T.width-=T.width*b},M.mw&&T.width>M.mw&&(b=(T.width-M.mw)/T.width,e()),M.mh&&T.height>M.mh&&(b=(T.height-M.mh)/T.height,e())),M.h&&(T.style.marginTop=Math.max(M.mh-T.height,0)/2+"px"),v[1]&&(M.loop||v[S+1])&&(T.style.cursor="pointer",T.onclick=function(){Z.next()}),setTimeout(function(){g(T)},1))}),setTimeout(function(){T.src=d},1)):d&&y.load(d,M.data,function(b,c){j===ab&&g("error"===c?db($,"Error").html(M.xhrError):a(this).contents())})}var n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,M,N,O,P,Q,R,S,T,V,W,X,Y,Z,_,cb,d={transition:"elastic",speed:300,fadeOut:300,width:!1,initialWidth:"600",innerWidth:!1,maxWidth:!1,height:!1,initialHeight:"450",innerHeight:!1,maxHeight:!1,scalePhotos:!0,scrolling:!0,inline:!1,html:!1,iframe:!1,fastIframe:!0,photo:!1,href:!1,title:!1,rel:!1,opacity:.9,preloading:!0,className:!1,retinaImage:!1,retinaUrl:!1,retinaSuffix:"@2x.$1",current:"image {current} of {total}",previous:"previous",next:"next",rotateLeft:"rotate left",rotateRight:"rotate right",zoom:"zoom",close:"close",xhrError:"This content failed to load.",imgError:"This image failed to load.",open:!1,returnFocus:!0,trapFocus:!0,reposition:!0,loop:!0,slideshow:!1,slideshowAuto:!0,slideshowSpeed:2500,slideshowStart:"start slideshow",slideshowStop:"stop slideshow",photoRegex:/\.(gif|png|jp(e|g|eg)|bmp|ico|webp)((#|\?).*)?$/i,onOpen:!1,onLoad:!1,onComplete:!1,onCleanup:!1,onClosed:!1,overlayClose:!0,escKey:!0,arrowKey:!0,top:!1,bottom:!1,left:!1,right:!1,fixed:!1,data:void 0,closeButton:!0},e="colorbox",f="cbox",g=f+"Element",h=f+"_open",i=f+"_load",j=f+"_complete",k=f+"_cleanup",l=f+"_closed",m=f+"_purge",L=a("<a/>"),U={zoom:"Out"},$="div",ab=0,bb={},mb=function(){function e(){clearTimeout(d)}function g(){(M.loop||v[S+1])&&(e(),d=setTimeout(Z.next,M.slideshowSpeed))}function h(){C.html(M.slideshowStop).unbind(b).one(b,l),L.bind(j,g).bind(i,e).bind(k,l),o.removeClass(a+"off").addClass(a+"on")}function l(){e(),L.unbind(j,g).unbind(i,e).unbind(k,l),C.html(M.slideshowStart).unbind(b).one(b,function(){Z.next(),h()}),o.removeClass(a+"on").addClass(a+"off")}var d,a=f+"Slideshow_",b="click."+f,c=!1;return function(){if(c){if(M.slideshow)return;c=!1,C.hide(),e(),L.unbind(j,g).unbind(i,e).unbind(k,l),o.removeClass(a+"off "+a+"on")}else M.slideshow&&v[1]&&(c=!0,M.slideshowAuto?h():l(),C.show())}}();a.colorbox||("undefined"==typeof jQuery.fn.rotate&&a.getScript("http://jquery-rotate.googlecode.com/svn/trunk/jquery.rotate.js",function(){}),a(ob),Z=a.fn[e]=a[e]=function(b,c){var f=this;if(b=b||{},ob(),pb()){if(a.isFunction(f))f=a("<a/>"),b.open=!0;else if(!f[0])return f;c&&(b.onComplete=c),f.each(function(){a.data(this,e,a.extend({},a.data(this,e)||d,b))}).addClass(g),(a.isFunction(b.open)&&b.open.call(f)||b.open)&&nb(f[0])}return f},Z.position=function(b,c){function k(){r[0].style.width=u[0].style.width=q[0].style.width=parseInt(o[0].style.width,10)-O+"px",q[0].style.height=s[0].style.height=t[0].style.height=parseInt(o[0].style.height,10)-N+"px"}var d,i,j,e=0,g=0,h=o.offset();if(w.unbind("resize."+f),o.css({top:-9e4,left:-9e4}),i=w.scrollTop(),j=w.scrollLeft(),M.fixed?(h.top-=i,h.left-=j,o.css({position:"fixed"})):(e=i,g=j,o.css({position:"absolute"})),g+=M.right!==!1?Math.max(w.width()-M.w-Q-O-gb(M.right,"x"),0):M.left!==!1?gb(M.left,"x"):Math.round(Math.max(w.width()-M.w-Q-O,0)/2),e+=M.bottom!==!1?Math.max(eb()-M.h-P-N-gb(M.bottom,"y"),0):M.top!==!1?gb(M.top,"y"):Math.round(Math.max(eb()-M.h-P-N,0)/2),o.css({top:h.top,left:h.left,visibility:"visible"}),p[0].style.width=p[0].style.height="9999px",d={width:M.w+Q+O,height:M.h+P+N,top:e,left:g},b){var l=0;a.each(d,function(a){return d[a]!==bb[a]?(l=b,void 0):void 0}),b=l}bb=d,b||o.css(d),o.dequeue().animate(d,{duration:b||0,complete:function(){k(),W=!1,p[0].style.width=M.w+Q+O+"px",p[0].style.height=M.h+P+N+"px",M.reposition&&setTimeout(function(){w.bind("resize."+f,Z.position)},1),c&&c()},step:k})},Z.resize=function(a){var b;if(V){a=a||{},a.width&&(M.w=gb(a.width,"x")-Q-O),a.innerWidth&&(M.w=gb(a.innerWidth,"x")),a.innerWidth||a.width||(M.w=gb(x.children(":first").width(),"x")),x.css({width:M.w}),a.height&&(M.h=gb(a.height,"y")-P-N),a.innerHeight&&(M.h=gb(a.innerHeight,"y")),a.innerHeight||a.height||(b=x.scrollTop(),x.css({height:"auto"}),M.h=x.height()),x.css({height:M.h}),b&&x.scrollTop(b);var c=0===a.speed?0:a.speed||M.speed;Z.position("none"===M.transition?0:c)}},Z.prep=function(c){function i(){return M.w=M.w||x.width(),M.w=M.mw&&M.mw<M.w?M.mw:M.w,M.w}function k(){return M.h=M.h||x.height(),M.h=M.mh&&M.mh<M.h?M.mh:M.h,M.h}if(V){var g,h="none"===M.transition?0:M.speed;x.empty().remove(),x=db($,"LoadedContent").append(c),x.hide().appendTo(y.show()).css({width:i(),overflow:M.scrolling?"auto":"hidden"}).css({height:k()}).prependTo(q),y.hide(),a(T).css({"float":"none"}),g=function(){function n(){a.support.opacity===!1&&o[0].style.removeAttribute("filter")}var g,l,c=v.length,i="frameBorder",k="allowTransparency";V&&(l=function(){clearTimeout(Y),z.hide(),lb(j,M.onComplete),U={zoom:"Out",x:x.width(),y:x.height()}},A.html(M.title).add(x).show(),hb(M,M.href)?(F.attr({title:d.rotateLeft}).html(M.rotateLeft),G.attr({title:d.rotateRight}).html(M.rotateRight),H.attr({title:d.zoom}).html(M.zoom)):(J.hide(),H.hide()),c>1?("string"==typeof M.current&&B.html(M.current.replace("{current}",S+1).replace("{total}",c)).show(),D[M.loop||c-1>S?"show":"hide"]().html(M.next),E[M.loop||S?"show":"hide"]().html(M.previous),D.attr({title:d.next}),E.attr({title:d.previous}),mb(),M.preloading&&a.each([fb(-1),fb(1)],function(){var c,d,f=v[this],g=a.data(f,e);g&&g.href?(c=g.href,a.isFunction(c)&&(c=c.call(f))):c=a(f).attr("href"),c&&hb(g,c)&&(c=ib(g,c),d=b.createElement("img"),d.src=c)})):K.hide(),M.iframe?(g=db("iframe")[0],i in g&&(g[i]=0),k in g&&(g[k]="true"),M.scrolling||(g.scrolling="no"),a(g).attr({src:M.href,name:(new Date).getTime(),"class":f+"Iframe",allowFullScreen:!0,webkitAllowFullScreen:!0,mozallowfullscreen:!0}).one("load",l).appendTo(x),L.one(m,function(){g.src="//about:blank"}),M.fastIframe&&a(g).trigger("load")):l(),"fade"===M.transition?o.fadeTo(h,1,n):n())},"fade"===M.transition?o.fadeTo(h,0,function(){Z.position(0,g)}):Z.position(h,g)}},Z.next=function(){!W&&v[1]&&(M.loop||v[S+1])&&(S=fb(1),nb(v[S]))},Z.prev=function(){!W&&v[1]&&(M.loop||S)&&(S=fb(-1),nb(v[S]))},Z.rotateLeft=function(){hb(M,M.href)&&(x.children(":first").rotateLeft(),x.children(":first").addClass(f+"Photo"),Z.resize({speed:0}),"In"==U.zoom&&(U.zoom="Out",Z.zoom()))},Z.rotateRight=function(){hb(M,M.href)&&(x.children(":first").rotateRight(),x.children(":first").addClass(f+"Photo"),Z.resize({speed:0}),"In"==U.zoom&&(U.zoom="Out",Z.zoom()))},Z.zoom=function(){if(hb(M,M.href)){var a=x.children(":first"),b=gb("98%","y")*(x.height()/o.height());"Out"==U.zoom?(U.x=x.width(),U.y=x.height(),U.zoom="In",b>o.height()&&(a.height(b),a.css("width","auto"))):(U.zoom="Out",a.width(U.x),a.height(U.y)),Z.resize(),H.attr({id:f+"Zoom"+U.zoom})}},Z.close=function(){V&&!X&&(X=!0,V=!1,lb(k,M.onCleanup),w.unbind("."+f),n.fadeTo(M.fadeOut||0,0),o.stop().fadeTo(M.fadeOut||0,0,function(){o.add(n).css({opacity:1,cursor:"auto"}).hide(),lb(m),x.empty().remove(),setTimeout(function(){X=!1,lb(l,M.onClosed)},1)}))},Z.remove=function(){o&&(o.stop(),a.colorbox.close(),o.stop().remove(),n.remove(),X=!1,o=null,a("."+g).removeData(e).removeClass(g),a(b).unbind("click."+f))},Z.element=function(){return a(R)},Z.settings=d)}(jQuery,document,window);;
(function ($) {

Drupal.behaviors.initColorbox = {
  attach: function (context, settings) {
    if (!$.isFunction($.colorbox)) {
      return;
    }
    $('.colorbox', context)
      .once('init-colorbox')
      .colorbox(settings.colorbox);
  }
};

{
  $(document).bind('cbox_complete', function () {
    Drupal.attachBehaviors('#cboxLoadedContent');
  });
}

})(jQuery);
;
(function ($) {

Drupal.behaviors.initColorboxDefaultStyle = {
  attach: function (context, settings) {
    $(document).bind('cbox_complete', function () {
      // Only run if there is a title.
      if ($('#cboxTitle:empty', context).length == false) {
        $('#cboxLoadedContent img', context).bind('mouseover', function () {
          $('#cboxTitle', context).slideDown();
        });
        $('#cboxOverlay', context).bind('mouseover', function () {
          $('#cboxTitle', context).slideUp();
        });
      }
      else {
        $('#cboxTitle', context).hide();
      }
    });
  }
};

})(jQuery);
;
//  $Id: lii-fundraiser-js.js 3068 2014-09-02 15:06:47Z wayne $

/**
 * @file
 * LII Fundraiser JS functions
 */

(function ($) {
Drupal.behaviors.liiFundraiser = {
    attach: lii_fundraiser_getSplash
};

function lii_fundraiser_OnLoad(splash) {
    //should not be necessary but doesnt hurt to check again
    if ( !splash.isvalid || lii_storage('get', 'lii_fundraiser') ) {return;}
    if ( location == Drupal.settings.lii_fundraiser.aboutlii_url ) {return;}

    var delay = lii_storage('get', 'lii_fundraiser_pagedelay');
    var clkcookie = ( delay ) ? delay : false;
    var numclicks = ( clkcookie ) ? Number(clkcookie.clicks) : 0;
    var numdelays = ( clkcookie ) ? Number(clkcookie.delay) : Number(Drupal.settings.lii_fundraiser.click_delay);

    if ( Boolean(numdelays) && numclicks < numdelays ) {
        //$.cookie('lii_fundraiser_pagedelay', JSON.stringify({delay: numdelays, clicks: numclicks + 1}), {path: '/'});
        lii_storage('set', 'lii_fundraiser_pagedelay', {delay: numdelays, clicks: numclicks + 1});
        return;
    }
    
    // insert screen
    var screen = document.createElement('div');
    screen.id = 'lii-fundraiser-screen';
    document.body.appendChild(screen);

    // insert splash
    var splashover = document.createElement('div');
    splashover.id = 'lii-fundraiser';
    splashover.className = Drupal.settings.lii_fundraiser.effect;
    splashover.innerHTML = splash.markup;
    document.body.appendChild(splashover);

    if ( Drupal.settings.lii_fundraiser.optimizely != '' ) {
            window.optimizely.push(["activate", Drupal.settings.lii_fundraiser.optimizely]);
            $('#lii-fundraiser').hide(); // optimizely will instantly show the splashover

            // flagging values sent to salesforce for optimizely experiment
            var optexp = $('#lii-fundraiser').attr('rel');
            if ( !optexp || optexp == '' ) { optexp = '-1'; }
            $('#lii-fundraiser-msgid').val(optexp);
            $('#lii-fundraiser-ctaid').val(optexp);
    }

    //assign button actions
    $("#lii-fundraiser-learnmore").click(lii_fundraiser_learnMore);
    $("#lii-fundraiser-remind-later").click(lii_fundraiser_remindMeLater);
    $("#lii-fundraiser-close-button").click(lii_fundraiser_donateNo);
    $("#lii-fundraiser-do-donation").click(lii_fundraiser_donateYes);
    //$("#lii-fundraiser-donate-amount").click(donateYes);

    //and finally we show the splashover
    //CSS is already loaded, only positioning
    lii_fundraiser_showFundraiserSplash(Drupal.settings.lii_fundraiser.effect, Drupal.settings.lii_fundraiser.speed);
}

function lii_fundraiser_showFundraiserSplash(effect, time) {
    $("#lii-fundraiser-screen").css("width", $(window).width()+"px");
    $("#lii-fundraiser-screen").css("height", $(window).height()+"px");
    if ( effect != 'banner' ) { $("#lii-fundraiser-screen").show(); }
    
    //alert("loading splashover");
    var winwidth = $(window).width()/2;
    var splashwd = $("#lii-fundraiser").width()/2;
    var xcoord = (winwidth - splashwd) + $(window).scrollLeft();

    var winheight = $(window).height()/2;
    var splashhgt = $("#lii-fundraiser").height()/2;
    var ycoord = (winheight - splashhgt) + $(window).scrollTop();

    if ( effect == 'genie' ) {
        var offset = $(Drupal.settings.lii_fundraiser.htmlid).first().offset();
        if ( !offset ) {
            // the htmlid object is null for some reason
            offset = {left: winwidth, top: winheight};
        }

        $("#lii-fundraiser").css("left", offset.left + 'px');
        $("#lii-fundraiser").css("top", offset.top + 'px');

        var height = $("#lii-fundraiser").height();
        $("#lii-fundraiser").css('height', 0);
        $("#lii-fundraiser").animate(
            {
                left: xcoord,
                top: ycoord,
                opacity: 'show',
                width: 'show',
                height: height
            },
            time
        );
    }
    else if ( effect == 'banner' ) {
        $("#lii-fundraiser").css("position", "fixed");
        $("#lii-fundraiser").css("left", xcoord + 'px');
        $("#lii-fundraiser").css("top", 0 );
        $("#lii-fundraiser").delay(1500).slideDown(time);
    }
    else {
        $("#lii-fundraiser").css("left", xcoord + "px");
        $("#lii-fundraiser").css("top", ycoord + "px");
        if ( effect == 'fade' ) { 
        	$("#lii-fundraiser").fadeIn(time);
        }
        else { $("#lii-fundraiser").show(time); }
    }
}


function lii_fundraiser_learnMore() {
    Drupal.settings.lii_fundraiser.has_learned_more = 1;
    window.open(Drupal.settings.lii_fundraiser.aboutlii_url,"learnMore").focus();
}

function lii_fundraiser_remindMeLater() {
    var remind_exp = Drupal.settings.lii_fundraiser.cookie_remindexp;
    if ( !remind_exp ) remind_exp = 3; // make sure we always have a value

    lii_fundraiser_closeSplashover(true);
    lii_fundraiser_recordSplashOptions('remind', remind_exp);
}

function lii_fundraiser_donateNo() {
    var no_exp = Drupal.settings.lii_fundraiser.cookie_noexp;
    if ( !no_exp ) no_exp = 60; // make sure we always have a value

    lii_fundraiser_closeSplashover(true);
    lii_fundraiser_recordSplashOptions('decline', no_exp);
}

function lii_fundraiser_donateYes() {
    var yes_exp = Drupal.settings.lii_fundraiser.cookie_yesexp;
    if ( !yes_exp ) yes_exp = 90; // make sure we always have a value
 
    lii_fundraiser_closeSplashover(false);

    var amt = $(this).val(); // this == button#lii-fundraiser-do-donation
    lii_fundraiser_recordSplashOptions(('donate '+amt).trim(), yes_exp);

    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("target", "_blank");
    form.setAttribute("action", Drupal.settings.lii_fundraiser.donation_url);

    var params = {status: 'skip', fromsplashover: true};
    if ( amt != '' && Number(amt) > 0 ) {
        params.amount = amt;
    }

    for (var i in params) {
        if (params.hasOwnProperty(i)) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = i;
            input.value = params[i];
            form.appendChild(input);
        }
    }

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}

function lii_fundraiser_closeSplashover(guilt_trip) {
    var effect = Drupal.settings.lii_fundraiser.effect;
    var time = 'fast';

    if ( effect == 'genie' ){
        if ( !guilt_trip || Drupal.settings.lii_fundraiser.thanksanyway == '' ) {
            $("#lii-fundraiser-screen").hide();

            var offset = $(Drupal.settings.lii_fundraiser.htmlid).offset();
            if ( !offset ) { // the htmlid object is null for some reason
                offset = {left: $(window).width()/2, top:$(window).height()/2};
            }

            $("#lii-fundraiser").animate(
                {
                    left: offset.left,
                    top: offset.top,
                    opacity: 'hide',
                    width: 'hide',
                    height: 'hide'
                },
                1000
            );
            //$("#lii-fundraiser").hide("fast");

        }
        else {
            $("#lii-fundraiser").fadeOut('slow',
                function() {
                    if ( Drupal.settings.lii_fundraiser.thanksanyway == '' ) {
                        // just in case the above condition does not catch for some reason
                        $("#lii-fundraiser-screen").hide();
                        return;
                    }

                    // insert the image
                    // set div wrapper css
                    // wait for image to be loaded so dimensions are be available
                    // show image, then close automatically
                    $("#lii-fundraiser").html("<img id='thanksanyway' src='"+Drupal.settings.lii_fundraiser.thanksanyway+"' />");
                    $("#lii-fundraiser").css({'width': 'auto', 'height': 'auto', 'background': 'initial'});
                    $("#lii-fundraiser img#thanksanyway").load(function () {
                        lii_fundraiser_showFundraiserSplash('fade', 'slow');
                        $("#lii-fundraiser").queue(function() {
                            setTimeout(function() {lii_fundraiser_closeSplashover(false);}, 600);
                            $(this).dequeue();
                        });
                    });
                }
            );
        }
    }
    else if ( effect == 'banner' ) {
        // * no screen with this effect
        $("#lii-fundraiser").slideUp(time);
    }
    else {
        $("#lii-fundraiser-screen").hide();
        ( effect == 'fade' ) ? $("#lii-fundraiser").fadeOut(time) : $("#lii-fundraiser").hide(time);
    }
}

function lii_fundraiser_recordSplashOptions(value, exp) {
    //return; // ww - testing graphics
    if ( !exp ) exp = 7; // make sure we always have a value

    var cookie = {
        suffix: Drupal.settings.lii_fundraiser.suffix,
        response: value,
        learnedmore: Drupal.settings.lii_fundraiser.has_learned_more,
        created: new Date().getTime(),
        pagesviewed: 1
    };

    cookie = JSON.parse(lii_storage('set', 'lii_fundraiser', cookie, exp)); //parse response for use later
    //console.log(cookie);
    lii_storage('remove', 'lii_fundraiser_pagedelay');

    var params = "suffix=" + cookie.suffix;
    params += "&response=" + cookie.response;
    params += "&learnedmore=" + cookie.learnedmore;
    params += "&onpage=" + location.pathname;
    params += "&msgid=" + $('#lii-fundraiser-msgid').val();
    params += "&ctaid=" + $('#lii-fundraiser-ctaid').val();

    $.ajax(
        {
            url: '/ajax/lii-fundraiser.php',//Drupal.settings.basePath + 'lii/fundraiser/response',
            data: "action=response&" + params,
            type: 'POST',
            dataType: 'json',
            success: function(result) {
                cookie.responseid = result.responseid;
                // we put it in the cookie for use later in the thankyou script.
                // but also in localStorage (or cookie again if not available) to
                // hopefully prevent people constantly seeing the splashover
                $.cookie('lii_fundraiser', JSON.stringify(cookie), {expires: new Date(cookie.expires), path: '/'});
                lii_storage('set', 'lii_fundraiser', cookie, cookie.expires);
            }
        }
    );
}

function lii_fundraiser_getSplash() {
    //return; // uncomment to completely disable the splashover and ajax

    //if user has disabled storage and cookies
    if ( !lii_storage('available') ) { return; }

    //if the user has seen the splashover and made a choice the cookie will be present
    var fundraiser = lii_storage('get', 'lii_fundraiser');
    if ( fundraiser ) {
        if ( fundraiser == 'disabled' ) { return; }
        //else
        if ( fundraiser.response == 'decline' ) {
            fundraiser.pagesviewed = fundraiser.pagesviewed + 1;
            if ( fundraiser.pagesviewed >= 500 ) {
                // if the user has viewed more than 500 pages since
                // they declined the fundraiser request, we are
                // asking them again anyway
                lii_storage('remove', 'lii_fundraiser');
            }
            else {
                lii_storage('set', 'lii_fundraiser', fundraiser);
            }
        }
        else {
            // the user selected 'remind me' or has donated
            // we are not going to bother them again.
            return;
        }
    }

    var survey = lii_storage('get', 'lii_survey');
    if ( survey ) {
        var asked = new Date(survey.created);
        asked.setDate(asked.getDate() + 5); // are we 5 days after asking?
        var today = new Date();
        if ( asked > today ) {return;}
        // else we continue on
    }

    // gets the markup and also checks for enabled and omission from page
    $.ajax(
        {
            url: '/ajax/lii-fundraiser.php',//Drupal.settings.basePath + 'lii/fundraiser/getsplash',
            data: "action=getsplash&onpage=" + location.pathname.slice(Drupal.settings.basePath.length),
            type: 'POST',
            dataType: 'json',
            success: function(result) {
                //alert(JSON.stringify(result));
                var splash = {isvalid: false, markup: ''};
                splash.isvalid = (Boolean(result.enabled) && !Boolean(result.omitted));

                if ( splash.isvalid ) {
                    Drupal.settings.lii_fundraiser = result.settings;
                    splash.markup = result.markup;
                    lii_fundraiser_OnLoad(splash);
                }
                else if ( !Boolean(result.enabled) ) {
                    lii_storage('set', 'lii_fundraiser', "disabled");
                }
            }
        }
    );
}
})(jQuery);;
//  $Id: lii.justia_find_lawyers_sidebar.js 2223 2013-07-31 18:28:34Z wayne $

/**
 * @file
 * LII Justia Lawyer JS function
 * 
 * - included file for Justia Find Lawyers block
 * - note that some styles are really kludged, stolen, and otherwise a mess, could use comprehensive review
 * - example query: $.getJSON('http://lawyers.law.cornell.edu/lawyers/injury-accident-law/locate?method=jsonp&limit=5&prefer_practice=1&callback=?&parts=query|basic|location|practice'
 */
(function ($) {
Drupal.behaviors.lii_justia_find_lawyers_sidebar = {
    attach: liiJustiaFindLawyers
};

function liiJustiaFindLawyers() {
    var paurl = Drupal.settings.lii_justia_find_lawyers_sidebar.paurl;
    var param = Drupal.settings.lii_justia_find_lawyers_sidebar.param;

    $.getJSON(
        paurl,
        param,
        function(data){
            if (data.profiles) {
                var title = 'Lawyers';
                if (data.practice_area_name) {
                    data.practice_area_name = data.practice_area_name.replace(/ (Law|Lawyer|Lawyers)$/i,'');
                    title = data.practice_area_name+ ' Lawyers';
                } 
                else if (data.search_query) {
                    title = '"'+data.search_query+'" Lawyers';
                }

                if (data.city_name && data.city_name != 'undefined') {
                    title += '<br />near ' + data.city_name + ', ' + data.state_name_full;
                }
                else if (data.state_name_full && data.state_name_full != 'undefined') {
                    title += '<br />in ' + data.state_name_full;
                }

                $("#lawyers_search_results").html('<strong class="lawyers_title">'+title+'</strong>');
                $("#lawyers_search_results").append('<div class="lawyers-get-listed"><a href="https://lawyers.justia.com/signup?ref=cornell">Lawyers: get listed for free!</a></div>');
                $("#lawyers_search_results").append('<div class="lawyers_list" />');

                var oddeven = 'odd';
                $.each(data.profiles, function(i,item) {
                    if (!item.img) { item.img = 'http://lawyers.law.cornell.edu/images/no-picture-listings.png'; }
                    
                    var practiceareas = (item.practice_areas) ? item.practice_areas.join(", ") : '';
                    
                    var badge_class = 'no_badges';
                    var badge_code = '';
                    if (typeof(item.badge_class) != 'undefined' && item.badge_class) {
                        badge_class = 'badge_'+item.badge_class;
                        badge_code = '<div class="badge"><span>'+item.badge_class+' Badge</span></div>';
                    }
                    
                    $("#lawyers_search_results").append('<div class="lawyer ' + oddeven + ' ' + badge_class + '"><a href="' + item.url + '" class="lawyer_image"><img src="' + item.img + '" width="33" /></a><p><strong><a href="' + item.url + '">' + item.full_name + '</a></strong><div class="pa" title="' + practiceareas + '">' + practiceareas + '</div><div class="loc">' + item.city + ', ' + item.state + '</div>'+badge_code+'</p></div>');
                    oddeven = ( oddeven == 'odd' ) ? 'even' : 'odd';
                });

                $('#seemorelawyers').attr('href',data.url);
                $('#seemorelawyers').html('See More Lawyers');
            }
            
            //$("#lawyers_search_results").append(paurl+'?'+param);
        }
    );
}
})(jQuery);;
(function ($) {

$(document).ready(function() {

  // Expression to check for absolute internal links.
  var isInternal = new RegExp("^(https?):\/\/" + window.location.host, "i");

  // Attach onclick event to document only and catch clicks on all elements.
  $(document.body).click(function(event) {
    // Catch the closest surrounding link of a clicked element.
    $(event.target).closest("a,area").each(function() {

      var ga = Drupal.settings.googleanalytics;
      // Expression to check for special links like gotwo.module /go/* links.
      var isInternalSpecial = new RegExp("(\/go\/.*)$", "i");
      // Expression to check for download links.
      var isDownload = new RegExp("\\.(" + ga.trackDownloadExtensions + ")$", "i");

      // Is the clicked URL internal?
      if (isInternal.test(this.href)) {
        // Skip 'click' tracking, if custom tracking events are bound.
        if ($(this).is('.colorbox')) {
          // Do nothing here. The custom event will handle all tracking.
        }
        // Is download tracking activated and the file extension configured for download tracking?
        else if (ga.trackDownload && isDownload.test(this.href)) {
          // Download link clicked.
          var extension = isDownload.exec(this.href);
          _gaq.push(["_trackEvent", "Downloads", extension[1].toUpperCase(), this.href.replace(isInternal, '')]);
        }
        else if (isInternalSpecial.test(this.href)) {
          // Keep the internal URL for Google Analytics website overlay intact.
          _gaq.push(["_trackPageview", this.href.replace(isInternal, '')]);
        }
      }
      else {
        if (ga.trackMailto && $(this).is("a[href^='mailto:'],area[href^='mailto:']")) {
          // Mailto link clicked.
          _gaq.push(["_trackEvent", "Mails", "Click", this.href.substring(7)]);
        }
        else if (ga.trackOutbound && this.href.match(/^\w+:\/\//i)) {
          if (ga.trackDomainMode == 2 && isCrossDomain(this.hostname, ga.trackCrossDomains)) {
            // Top-level cross domain clicked. document.location is handled by _link internally.
            event.preventDefault();
            _gaq.push(["_link", this.href]);
          }
          else {
            // External link clicked.
            _gaq.push(["_trackEvent", "Outbound links", "Click", this.href]);
          }
        }
      }
    });
  });

  // Colorbox: This event triggers when the transition has completed and the
  // newly loaded content has been revealed.
  $(document).bind("cbox_complete", function() {
    var href = $.colorbox.element().attr("href");
    if (href) {
      _gaq.push(["_trackPageview", href.replace(isInternal, '')]);
    }
  });

});

/**
 * Check whether the hostname is part of the cross domains or not.
 *
 * @param string hostname
 *   The hostname of the clicked URL.
 * @param array crossDomains
 *   All cross domain hostnames as JS array.
 *
 * @return boolean
 */
function isCrossDomain(hostname, crossDomains) {
  /**
   * jQuery < 1.6.3 bug: $.inArray crushes IE6 and Chrome if second argument is
   * `null` or `undefined`, http://bugs.jquery.com/ticket/10076,
   * https://github.com/jquery/jquery/commit/a839af034db2bd934e4d4fa6758a3fed8de74174
   *
   * @todo: Remove/Refactor in D8
   */
  if (!crossDomains) {
    return false;
  }
  else {
    return $.inArray(hostname, crossDomains) > -1 ? true : false;
  }
}

})(jQuery);
;
