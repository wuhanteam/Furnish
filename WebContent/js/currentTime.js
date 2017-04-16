function showTime() {
	var myDate = new Date();
	var year = myDate.getFullYear();
	var month = myDate.getMonth() + 1;
	var date = myDate.getDate();
	var dateArr = [ "日", "一", '二', '三', '四', '五', '六' ];
	var day = myDate.getDay();
	var hours = formatTime(myDate.getHours());
	var minutes = formatTime(myDate.getMinutes());
	var seconds = formatTime(myDate.getSeconds());

	return " " + year + "年" + month + "月" + date + "日" + " 星期"
			+ dateArr[day] + " " + hours + ":" + minutes + ":" + seconds;
}

// 格式化时间：分秒。
function formatTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}