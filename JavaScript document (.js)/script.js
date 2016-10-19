!DOCTYPE html
<html>
<head>
</head>
<body onload="httpGetAsync("http://us.battle.net/wow/en/pvp/leaderboards/3v3", run())>
</body>
<script>
function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}
</script>