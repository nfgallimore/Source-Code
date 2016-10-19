
/*!
 * jQuery UI 1.8.7
 *
 * Copyright 2010, AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * http://docs.jquery.com/UI
 */
(function(c,j){function k(a){return!c(a).parents().andSelf().filter(function(){return c.curCSS(this,"visibility")==="hidden"||c.expr.filters.hidden(this)}).length}c.ui=c.ui||{};if(!c.ui.version){c.extend(c.ui,{version:"1.8.7",keyCode:{ALT:18,BACKSPACE:8,CAPS_LOCK:20,COMMA:188,COMMAND:91,COMMAND_LEFT:91,COMMAND_RIGHT:93,CONTROL:17,DELETE:46,DOWN:40,END:35,ENTER:13,ESCAPE:27,HOME:36,INSERT:45,LEFT:37,MENU:93,NUMPAD_ADD:107,NUMPAD_DECIMAL:110,NUMPAD_DIVIDE:111,NUMPAD_ENTER:108,NUMPAD_MULTIPLY:106,
NUMPAD_SUBTRACT:109,PAGE_DOWN:34,PAGE_UP:33,PERIOD:190,RIGHT:39,SHIFT:16,SPACE:32,TAB:9,UP:38,WINDOWS:91}});c.fn.extend({_focus:c.fn.focus,focus:function(a,b){return typeof a==="number"?this.each(function(){var d=this;setTimeout(function(){c(d).focus();b&&b.call(d)},a)}):this._focus.apply(this,arguments)},scrollParent:function(){var a;a=c.browser.msie&&/(static|relative)/.test(this.css("position"))||/absolute/.test(this.css("position"))?this.parents().filter(function(){return/(relative|absolute|fixed)/.test(c.curCSS(this,
"position",1))&&/(auto|scroll)/.test(c.curCSS(this,"overflow",1)+c.curCSS(this,"overflow-y",1)+c.curCSS(this,"overflow-x",1))}).eq(0):this.parents().filter(function(){return/(auto|scroll)/.test(c.curCSS(this,"overflow",1)+c.curCSS(this,"overflow-y",1)+c.curCSS(this,"overflow-x",1))}).eq(0);return/fixed/.test(this.css("position"))||!a.length?c(document):a},zIndex:function(a){if(a!==j)return this.css("zIndex",a);if(this.length){a=c(this[0]);for(var b;a.length&&a[0]!==document;){b=a.css("position");
if(b==="absolute"||b==="relative"||b==="fixed"){b=parseInt(a.css("zIndex"),10);if(!isNaN(b)&&b!==0)return b}a=a.parent()}}return 0},disableSelection:function(){return this.bind((c.support.selectstart?"selectstart":"mousedown")+".ui-disableSelection",function(a){a.preventDefault()})},enableSelection:function(){return this.unbind(".ui-disableSelection")}});c.each(["Width","Height"],function(a,b){function d(f,g,l,m){c.each(e,function(){g-=parseFloat(c.curCSS(f,"padding"+this,true))||0;if(l)g-=parseFloat(c.curCSS(f,
"border"+this+"Width",true))||0;if(m)g-=parseFloat(c.curCSS(f,"margin"+this,true))||0});return g}var e=b==="Width"?["Left","Right"]:["Top","Bottom"],h=b.toLowerCase(),i={innerWidth:c.fn.innerWidth,innerHeight:c.fn.innerHeight,outerWidth:c.fn.outerWidth,outerHeight:c.fn.outerHeight};c.fn["inner"+b]=function(f){if(f===j)return i["inner"+b].call(this);return this.each(function(){c(this).css(h,d(this,f)+"px")})};c.fn["outer"+b]=function(f,g){if(typeof f!=="number")return i["outer"+b].call(this,f);return this.each(function(){c(this).css(h,
d(this,f,true,g)+"px")})}});c.extend(c.expr[":"],{data:function(a,b,d){return!!c.data(a,d[3])},focusable:function(a){var b=a.nodeName.toLowerCase(),d=c.attr(a,"tabindex");if("area"===b){b=a.parentNode;d=b.name;if(!a.href||!d||b.nodeName.toLowerCase()!=="map")return false;a=c("img[usemap=#"+d+"]")[0];return!!a&&k(a)}return(/input|select|textarea|button|object/.test(b)?!a.disabled:"a"==b?a.href||!isNaN(d):!isNaN(d))&&k(a)},tabbable:function(a){var b=c.attr(a,"tabindex");return(isNaN(b)||b>=0)&&c(a).is(":focusable")}});
c(function(){var a=document.body,b=a.appendChild(b=document.createElement("div"));c.extend(b.style,{minHeight:"100px",height:"auto",padding:0,borderWidth:0});c.support.minHeight=b.offsetHeight===100;c.support.selectstart="onselectstart"in b;a.removeChild(b).style.display="none"});c.extend(c.ui,{plugin:{add:function(a,b,d){a=c.ui[a].prototype;for(var e in d){a.plugins[e]=a.plugins[e]||[];a.plugins[e].push([b,d[e]])}},call:function(a,b,d){if((b=a.plugins[b])&&a.element[0].parentNode)for(var e=0;e<b.length;e++)a.options[b[e][0]]&&
b[e][1].apply(a.element,d)}},contains:function(a,b){return document.compareDocumentPosition?a.compareDocumentPosition(b)&16:a!==b&&a.contains(b)},hasScroll:function(a,b){if(c(a).css("overflow")==="hidden")return false;b=b&&b==="left"?"scrollLeft":"scrollTop";var d=false;if(a[b]>0)return true;a[b]=1;d=a[b]>0;a[b]=0;return d},isOverAxis:function(a,b,d){return a>b&&a<b+d},isOver:function(a,b,d,e,h,i){return c.ui.isOverAxis(a,d,h)&&c.ui.isOverAxis(b,e,i)}})}})(jQuery);
;
/* ===========================================================================
 *
 * JQuery URL Parser
 * Version 1.0
 * Parses URLs and provides easy access to information within them.
 *
 * Author: Mark Perkins
 * Author email: mark@allmarkedup.com
 *
 * For full documentation and more go to http://projects.allmarkedup.com/jquery_url_parser/
 *
 * ---------------------------------------------------------------------------
 *
 * CREDITS:
 *
 * Parser based on the Regex-based URI parser by Stephen Levithian.
 * For more information (including a detailed explaination of the differences
 * between the 'loose' and 'strict' pasing modes) visit http://blog.stevenlevithan.com/archives/parseuri
 *
 * ---------------------------------------------------------------------------
 *
 * LICENCE:
 *
 * Released under a MIT Licence. See licence.txt that should have been supplied with this file,
 * or visit http://projects.allmarkedup.com/jquery_url_parser/licence.txt
 *
 * ---------------------------------------------------------------------------
 * 
 * EXAMPLES OF USE:
 *
 * Get the domain name (host) from the current page URL
 * jQuery.url.attr("host")
 *
 * Get the query string value for 'item' for the current page
 * jQuery.url.param("item") // null if it doesn't exist
 *
 * Get the second segment of the URI of the current page
 * jQuery.url.segment(2) // null if it doesn't exist
 *
 * Get the protocol of a manually passed in URL
 * jQuery.url.setUrl("http://allmarkedup.com/").attr("protocol") // returns 'http'
 *
 */

jQuery.url = function()
{
	var segments = {};
	
	var parsed = {};
	
	/**
    * Options object. Only the URI and strictMode values can be changed via the setters below.
    */
  	var options = {
	
		url : window.location, // default URI is the page in which the script is running
		
		strictMode: false, // 'loose' parsing by default
	
		key: ["source","protocol","authority","userInfo","user","password","host","port","relative","path","directory","file","query","anchor"], // keys available to query 
		
		q: {
			name: "queryKey",
			parser: /(?:^|&)([^&=]*)=?([^&]*)/g
		},
		
		parser: {
			strict: /^(?:([^:\/?#]+):)?(?:\/\/((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?))?((((?:[^?#\/]*\/)*)([^?#]*))(?:\?([^#]*))?(?:#(.*))?)/, // more intuitive, fails on relative paths and deviates from specs
			loose:  /^(?:(?![^:@]+:[^:@\/]*@)([^:\/?#.]+):)?(?:\/\/)?((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?)(((\/(?:[^?#](?![^?#\/]*\.[^?#\/.]+(?:[?#]|$)))*\/?)?([^?#\/]*))(?:\?([^#]*))?(?:#(.*))?)/ //less intuitive, more accurate to the specs
		}
		
	};
	
    /**
     * Deals with the parsing of the URI according to the regex above.
 	 * Written by Steven Levithan - see credits at top.
     */		
	var parseUri = function()
	{
		str = decodeURI( options.url );
		
		var m = options.parser[ options.strictMode ? "strict" : "loose" ].exec( str );
		var uri = {};
		var i = 14;

		while ( i-- ) {
			uri[ options.key[i] ] = m[i] || "";
		}

		uri[ options.q.name ] = {};
		uri[ options.key[12] ].replace( options.q.parser, function ( $0, $1, $2 ) {
			if ($1) {
				uri[options.q.name][$1] = $2;
			}
		});

		return uri;
	};

    /**
     * Returns the value of the passed in key from the parsed URI.
  	 * 
	 * @param string key The key whose value is required
     */		
	var key = function( key )
	{
		if ( ! parsed.length )
		{
			setUp(); // if the URI has not been parsed yet then do this first...	
		} 
		if ( key == "base" )
		{
			if ( parsed.port !== null && parsed.port !== "" )
			{
				return parsed.protocol+"://"+parsed.host+":"+parsed.port+"/";	
			}
			else
			{
				return parsed.protocol+"://"+parsed.host+"/";
			}
		}
	
		return ( parsed[key] === "" ) ? null : parsed[key];
	};
	
	/**
     * Returns the value of the required query string parameter.
  	 * 
	 * @param string item The parameter whose value is required
     */		
	var param = function( item )
	{
		if ( ! parsed.length )
		{
			setUp(); // if the URI has not been parsed yet then do this first...	
		}
		return ( parsed.queryKey[item] === null ) ? null : parsed.queryKey[item];
	};

    /**
     * 'Constructor' (not really!) function.
     *  Called whenever the URI changes to kick off re-parsing of the URI and splitting it up into segments. 
     */	
	var setUp = function()
	{
		parsed = parseUri();
		
		getSegments();	
	};
	
    /**
     * Splits up the body of the URI into segments (i.e. sections delimited by '/')
     */
	var getSegments = function()
	{
		var p = parsed.path;
		segments = []; // clear out segments array
		segments = parsed.path.length == 1 ? {} : ( p.charAt( p.length - 1 ) == "/" ? p.substring( 1, p.length - 1 ) : path = p.substring( 1 ) ).split("/");
	};
	
	return {
		
	    /**
	     * Sets the parsing mode - either strict or loose. Set to loose by default.
	     *
	     * @param string mode The mode to set the parser to. Anything apart from a value of 'strict' will set it to loose!
	     */
		setMode : function( mode )
		{
			strictMode = mode == "strict" ? true : false;
			return this;
		},
		
		/**
	     * Sets URI to parse if you don't want to to parse the current page's URI.
		 * Calling the function with no value for newUri resets it to the current page's URI.
	     *
	     * @param string newUri The URI to parse.
	     */		
		setUrl : function( newUri )
		{
			options.url = newUri === undefined ? window.location : newUri;
			setUp();
			return this;
		},		
		
		/**
	     * Returns the value of the specified URI segment. Segments are numbered from 1 to the number of segments.
		 * For example the URI http://test.com/about/company/ segment(1) would return 'about'.
		 *
		 * If no integer is passed into the function it returns the number of segments in the URI.
	     *
	     * @param int pos The position of the segment to return. Can be empty.
	     */	
		segment : function( pos )
		{
			if ( ! parsed.length )
			{
				setUp(); // if the URI has not been parsed yet then do this first...	
			} 
			if ( pos === undefined )
			{
				return segments.length;
			}
			return ( segments[pos] === "" || segments[pos] === undefined ) ? null : segments[pos];
		},
		
		attr : key, // provides public access to private 'key' function - see above
		
		param : param // provides public access to private 'param' function - see above
		
	};
	
}();;
/*!
 * jQuery Cookie Plugin v1.3
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2011, Klaus Hartl
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.opensource.org/licenses/GPL-2.0
 */
(function ($, document, undefined) {

	var pluses = /\+/g;

	function raw(s) {
		return s;
	}

	function decoded(s) {
		return decodeURIComponent(s.replace(pluses, ' '));
	}

	var config = $.cookie = function (key, value, options) {

		// write
		if (value !== undefined) {
			options = $.extend({}, config.defaults, options);

			if (value === null) {
				options.expires = -1;
			}

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setDate(t.getDate() + days);
			}

			value = config.json ? JSON.stringify(value) : String(value);

			return (document.cookie = [
				encodeURIComponent(key), '=', config.raw ? value : encodeURIComponent(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// read
		var decode = config.raw ? raw : decoded;
		var cookies = document.cookie.split('; ');
		for (var i = 0, l = cookies.length; i < l; i++) {
			var parts = cookies[i].split('=');
			if (decode(parts.shift()) === key) {
				var cookie = decode(parts.join('='));
				return config.json ? JSON.parse(cookie) : cookie;
			}
		}

		return null;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		if ($.cookie(key) !== null) {
			$.cookie(key, null, options);
			return true;
		}
		return false;
	};

})(jQuery, document);
;
//  $Id: lii.funcs.js 2160 2013-06-21 20:45:36Z wayne $

/**
 * @file
 * LII JS functions
 */
 
 // damn IE 8
 if (typeof String.prototype.trim !== 'function') {
  String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, ''); 
  }
}
 
 // functions declared globally and using long hand 'jQuery' because IE <= 8 is dumb about scope

var iWantMyPayPalButton = 
function iWantMyPayPalButton() {
    document.write('<button id="iwantmypaypal">I Want to Use my Paypal Account</button>');
    $('#iwantmypaypal').click( function (event) {
        jQuery.ajax({
            url: '/ajax/lii-fundraiser.php',//Drupal.settings.basePath + 'lii/fundraiser/response',
            data: "action=iwantmypaypal",
            type: 'POST',
            dataType: 'json',
            success: function(result) { /*nothing*/ }
        });
    });
}

/**
 * overloaded function to manage 'storage'
 * - checks if local/session Storage is implmented in the browser
 * - checks if cookies are enabled
 * - get/set key:value pairs (in Storage or as a cookie)
 * - removes key:value pairs (in Storage or as a cookie)
 *
 * @param action  : the action to perform
 *      - 'available' = verify that a storage option is possible
 *      - 'get' = get a value from storage; returns null, Scalar, Object
 *      - 'set' = set a key:value pair; value converted to String if Object
 *      - 'remove' = delete a key:value pair
 *
 * @param key     : the key to store; String; n/a with available
 * @param value   : the value to store; any type; n/a with get or remove
 * @param expires : when to expire the value; Numeric number of days; Optional; n/a all but set
 *            - if using HTMLStorage 'value' converted to an Object; value.expires = expireDate
 *            - during 'get', check is made for expired; null returned if expired
 *            - if ommitted, expires end of session
 *
 * @return
 * - 'available' = Boolean
 * - 'get'       = null or stored value; will be Object if Scalar set with an expires
 * - 'set'       = stored value
 * - 'remove'    = null
 *
 */
var lii_storage = 
function lii_storage(action, key, value, expires) {
    var ret = null;
    
     // damn IE 7 simply wont support this functionality
     // need JSON parsing for A LOT of stuff
	if ( typeof JSON === 'undefined') { return ret; }
    
    switch ( action ) {
        case 'available':
            if ( typeof(Storage) !== "undefined" ) { ret = true; }
            else { //HTMLStorage (local or session) is not available
                jQuery.cookie('lii_cookies_enabled', 'enabled', {path: '/'});
                if ( jQuery.cookie('lii_cookies_enabled') ) {
                    ret = true;
                    jQuery.removeCookie('lii_cookies_enabled', {path: '/'});
                }
                else { ret = false; } //storage and cookies not available
            }
            break;

        case 'get':
            if ( typeof(Storage) !== "undefined" ) {
                ret = localStorage.getItem(key);
                if ( ret ) {
                    try { ret = JSON.parse(ret); } catch(err) { return ret; }
                    var today = new Date();
                    var expire = new Date(ret.expires);
                    if ( expire < today ) {
                        localStorage.removeItem(key);
                        ret = null;
                    }
                }
                else {
                    ret = sessionStorage.getItem(key);
                    if ( ret ) {try { ret = JSON.parse(ret); } catch(err) {}}
                }
            }

            if ( !ret ) {
                // check for a cookie version if not found in storage
                ret = jQuery.cookie(key);
            }
            // ret will be null, String, Numeric, Object
            break;

        case 'set':          
            if ( typeof(value) == 'object' && expires ) {
				var expire = new Date();
				if (expires instanceof Date) { expire = expires; }
				else if (typeof expires === 'number') {
					expire.setTime(expire.getTime() + ((expires*24)*60*60*1000));
				}
				else {
					// some other value is placed in options.expires, attempt to make a Date object
					try { expire = new Date(expires); } catch(err) { /*expire unmodified*/ }
				}

                value.expires = expire;
            }
            var _value = JSON.stringify(value); // retains type if not an Object

            if ( typeof(Storage) !== "undefined" ) {
                if ( expires && typeof(value) != 'object' )  {
                    // non object type but have an expire
                    _value = JSON.stringify({value: value, expires: expire});
                }

                if (value.expires) { localStorage.setItem(key, _value); }
                else { sessionStorage.setItem(key, _value); }
            }
            else {
                // an undefined 'expires' makes the cookie a session cookie
                jQuery.cookie(key, _value, {expires: expires, path: '/'})
            }

            ret = _value;
            break;

        case 'remove':
            if ( typeof(Storage) !== "undefined" ) {
                localStorage.removeItem(key);
                sessionStorage.removeItem(key);
            }
            jQuery.removeCookie(key, {path: '/'});
            break;

        default:
            break;
    }

    return ret;
};
;
(function ($) {

/**
 * Retrieves the summary for the first element.
 */
$.fn.drupalGetSummary = function () {
  var callback = this.data('summaryCallback');
  return (this[0] && callback) ? $.trim(callback(this[0])) : '';
};

/**
 * Sets the summary for all matched elements.
 *
 * @param callback
 *   Either a function that will be called each time the summary is
 *   retrieved or a string (which is returned each time).
 */
$.fn.drupalSetSummary = function (callback) {
  var self = this;

  // To facilitate things, the callback should always be a function. If it's
  // not, we wrap it into an anonymous function which just returns the value.
  if (typeof callback != 'function') {
    var val = callback;
    callback = function () { return val; };
  }

  return this
    .data('summaryCallback', callback)
    // To prevent duplicate events, the handlers are first removed and then
    // (re-)added.
    .unbind('formUpdated.summary')
    .bind('formUpdated.summary', function () {
      self.trigger('summaryUpdated');
    })
    // The actual summaryUpdated handler doesn't fire when the callback is
    // changed, so we have to do this manually.
    .trigger('summaryUpdated');
};

/**
 * Sends a 'formUpdated' event each time a form element is modified.
 */
Drupal.behaviors.formUpdated = {
  attach: function (context) {
    // These events are namespaced so that we can remove them later.
    var events = 'change.formUpdated click.formUpdated blur.formUpdated keyup.formUpdated';
    $(context)
      // Since context could be an input element itself, it's added back to
      // the jQuery object and filtered again.
      .find(':input').andSelf().filter(':input')
      // To prevent duplicate events, the handlers are first removed and then
      // (re-)added.
      .unbind(events).bind(events, function () {
        $(this).trigger('formUpdated');
      });
  }
};

/**
 * Prepopulate form fields with information from the visitor cookie.
 */
Drupal.behaviors.fillUserInfoFromCookie = {
  attach: function (context, settings) {
    $('form.user-info-from-cookie').once('user-info-from-cookie', function () {
      var formContext = this;
      $.each(['name', 'mail', 'homepage'], function () {
        var $element = $('[name=' + this + ']', formContext);
        var cookie = $.cookie('Drupal.visitor.' + this);
        if ($element.length && cookie) {
          $element.val(cookie);
        }
      });
    });
  }
};

})(jQuery);
;
