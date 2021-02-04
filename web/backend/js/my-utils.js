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

function strToObj(str) {
    //format: id.name.price.num.amount
    //name can't contain "."
    const arr = str.split(".");
    const id = parseInt(arr[0]);
    const name = arr[1];
    const price = parseInt(arr[2]);
    const num = parseInt(arr[3]);
    const amount = parseInt(arr[4]);

    return {"id": id, "name": name, "price": price, "num": num, "amount": amount};
}

function strToObjList(listStr) {
    // split by ","
    let arr = listStr.split(",");
    let res = {};
    arr.forEach(function (item, index) {
        let tmp = strToObj(item);
        res.put(tmp.id, tmp);
    });
    return res;
}

function objToStr(data) {
    return "" + data.id + "." + data.name + "." + data.price + "." + data.num + "." + data.amount;
}

function objListToStr(data) {
    //list 里面存的是 引用
    let flag = 0;
    let ans = "";
    data.forEach(function (item, index) {
        if (flag === 1) {
            ans += ",";
        }
        ans += item.id + ":";
        ans += objToStr(item);
        flag = 1;
    });
    return ans;
}