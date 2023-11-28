
function clockTimer()
{
    const date = new Date();
    const currentDate = new Date();
    const TIMEOUT=13000;
    const clock = document.getElementById("clock");

    const YEAR = currentDate.getFullYear();
    const MONTH = currentDate.getMonth() + 1;
    const DAY = currentDate.getDate();

    const time = [currentDate.getHours(),currentDate.getMinutes(),currentDate.getSeconds()];
    const dayOfWeek = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
    const days = date.getDay();

    if(time[0] < 10){time[0] = "0"+ time[0];}
    if(time[1] < 10){time[1] = "0"+ time[1];}
    if(time[2] < 10){time[2] = "0"+ time[2];}

    const current_time = [time[0],time[1],time[2]].join(':');

    const current_date=dayOfWeek[days]+","+[DAY,MONTH,YEAR].join('.')

    clock.innerHTML = current_time;
    document.getElementById("date").innerHTML = current_date;

    setTimeout("clockTimer()", TIMEOUT);
}