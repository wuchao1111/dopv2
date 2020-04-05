export const test = () => {
    alert("test")
};

// zipkin存储的时间戳是微秒格式，16位
export const timestampToDate = (timestamp) => {
    // console.log("要转换的时间戳是: " + timestamp);
    let main = parseInt(timestamp/1000), remain = parseInt(timestamp%1000);
    let date = new Date(main);
    let year = date.getFullYear();
    let month = formatTwoDigit(date.getMonth()+1);
    let day = formatTwoDigit(date.getDate());

    let hour = formatTwoDigit(date.getHours());
    let minute= formatTwoDigit(date.getMinutes());
    let second = formatTwoDigit(date.getSeconds());

    return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" +second;
    // console.log("时间戳转换时间" + result);
    // return result;
};

const formatTwoDigit = (value) => {
    return value < 10 ? "0" + value : value;
};

// date为时间Date格式，time为string，格式 hh:mm
export const toTimestamp = (date, time) => {
    // 得到当前年月日零点的时间戳（当前时间戳减去超过零点的数值）
    let hourOver=date.getHours();
    let minutesOver= date.getMinutes();
    let second=date.getSeconds();
    // 时分
    let hour = parseInt(time.split(":")[0]), minutes = parseInt(time.split(":")[1]);

    let result = date.getTime() + 3600000 * (hour - hourOver) + 60000 * (minutes - minutesOver) - 1000 * second;
    console.log("result: " + result);
    return result;
};

// duration输入单位可能为μs或ms或s,需要转为微秒 e.g.100000 (for 100ms)
export const toMicroseconds = (value) => {
    // console.log("输入为： !" + value + "!");
    if (value === "") {
        return 0;
    }
    let result = 0;
    if (value.endsWith("ms")) {
        result = value.substr(0, value.length - 2) * 1000;
        // console.log("毫秒的: " + result);
    } else if (value.endsWith("μs")) { //μs为单位
        result = value.substr(0, value.length - 2);
        // console.log("微秒的: " + result);
    } else if (value.endsWith("s")) {
        result = value.substr(0, value.length - 1) * 1000000;
        // console.log("秒的: " + result);
    } else {
        result = value;
        // console.log("没有单位（默认微秒）: " + result);
    }
    // zipkin要求传入参数为整数
    return parseInt(result);
};

// 获取当前时间 格式hh:mm
export const getCurrentTime = () => {
    let now = new Date();
    let hour=now.getHours();
    let minute= now.getMinutes();
    hour = (hour < 10) ? "0" + hour : hour;
    minute = (minute < 10) ? "0" + minute : minute;

    let result = hour + ":" + minute;
    console.log(result);
    return result;
};

// 获取当前时间戳
export const getCurrentTimestamp = () => {
    return new Date().getTime();
};

// 数据库直接读到的duration是微秒级别，根据数值转为ms或s
export const formatDuration = (value) => {
    let ms = value/1000;
    if (ms > 1000) { //>1s了
        return new Number(ms / 1000).toFixed(3) + "s";
    } else {
        return ms + "ms";
    }
};
