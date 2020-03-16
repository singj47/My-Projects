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


