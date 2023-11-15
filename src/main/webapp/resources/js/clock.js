
function clockTimer()
{
    var date = new Date();

    var time = [date.getHours(),date.getMinutes(),date.getSeconds()];
    var dayOfWeek = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
    var days = date.getDay();
    var date_arr =[date.getDay(),date.getMonth(),date.getFullYear()]

    if(time[0] < 10){time[0] = "0"+ time[0];}
    if(time[1] < 10){time[1] = "0"+ time[1];}
    if(time[2] < 10){time[2] = "0"+ time[2];}

    var current_time = [time[0],time[1],time[2]].join(':');
    var clock = document.getElementById("clock");
    var current_date=dayOfWeek[days]+","+[date_arr[0],date_arr[1],date_arr[2]].join('.')

    clock.innerHTML = current_time;
    document.getElementById("date").innerHTML = current_date;

    setTimeout("clockTimer()", 13000);
}