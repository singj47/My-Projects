#  CS 1XA3 Project02 - <singj47>
## Overview

 This webpage is <Jaskaran>'s custom CV where I have mentioned about:

1. My Education 

2. My Volunteering

3. My Achievements

by using JS,CSS and html coding .

## Custom Javascript Code

 Description: This feature enables the user to choose an alternate colour mode (i.e the night shift mode ) and then change it back to normal by clicking on it again . The code could be found in
 the file myjava.js.

``` javascript
function switchcolor()
{
   var buttonmode=document.getElementById("bgmode");
        if(buttonmode.value=="Dark Mode")
        {
                document.getElementById("tint").style.filter="brightness(70%)";
                document.getElementById("tint").style.backgroundColor="rgba(0,0,0,0.5)";
                buttonmode.value="Light Mode";
        }
        else
        {
                document.getElementById("tint").style.filter="brightness(100%)";
                document.getElementById("tint").style.backgroundColor="rgba(0,0,0,0)";
        buttonmode.value="Dark Mode";
        }

}
```

## Custom CSS Code

Description: this feature enables the user to see the content jotted under different titles just by hovering over it .

``` css
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Times New Roman", Times New Roman}

#tint{
z-index:1;
position:absolute;
margin:0px;
height:auto;
width:100%;
}

#vol{
content:"";
position:relative;
display:table;
clear:both;
background-color:white;
margin-bottom:20px;
padding:16px;
color:gray;
width:100%;

}
#overlay_vol{
        height:0;
        overflow:hidden;
}
#vol:hover #overlay_vol{
height:100%;
}
#edu{
content:"";
position:relative;
display:table;
clear:both;
background-color:white;
margin-bottom:20px;
padding:16px;
color:gray;
width:100%;
}
#overlay_edu{
        height:0;
        overflow:hidden;
}
#edu:hover #overlay_edu{
height:100%;
}

#ach{
content:"";
position:relative;
display:table;
clear:both;
background-color:white;
margin-bottom:20px;
padding:16px;
color:gray;
width:100%;
}
#overlay_ach{
        height:0;
        overflow:hidden;
}
#ach:hover #overlay_ach{height:100%;}
```

## References

   - The html document used the following HTML Template from w3schools
	https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_cv&stacked=h
   - The following snippets of javascript code were self implemented.

