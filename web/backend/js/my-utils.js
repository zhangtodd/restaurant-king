function formatTen(num) {
    return num > 9 ? (num + "") : ("0" + num);
}

function formatDate(date) {
    var date = new Date(date)
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    return year + "-" + formatTen(month) + "-" + formatTen(day) + " " + formatTen(hour) + ":" + formatTen(minute) + ":" + formatTen(second);
}

function intToDouble(num) {
    const decimalPart = num % 100;
    const integerPart = parseInt(num / 100);
    return integerPart + "." + decimalPart;
}

function doubleToInt(num) {
    return parseInt(num * 100);
}