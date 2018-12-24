/**
 * 公共方法
 */
var common = new Object({
	/**
	 * 异步提交封装
	 * @param url 地址
	 * @param params 参数
	 * @param callback 回调
	 */
	ajaxPost : function (url,params,callback){
		$.ajax({
			type : 'POST',
			url : url,
			dataType : 'json',
			data : params,
			success : function(data){
				callback(data);
			},
			error : function(data){
				
			}
		});
	},
	/**
	 * ajax同步请求
	 */
	ajaxPostSync : function (url,params,callback){
		$.ajax({
			type : 'POST',
			url : url,
			dataType : 'json',
			data : params,
			async: false,
			success : function(data){
				callback(data);
			},
			error : function(data){
				
			}
		});
	},
	
	/**
	 * 页面更改
	 * @param pageIndex 页码
	 * @param param url传参字符串
	 */
	changePage : function(pageIndex, param){
		var queryForm = $("#queryForm");
		if (param) {
			queryForm[0].action = pageIndex + "?" + param;
		}else{
			queryForm[0].action = pageIndex;
		}
		queryForm[0].submit();
	},
	/**
	 * 更改页面大小
	 * @param select 页面大小
	 */
	changePageSize : function(select){
		var pageSizeObj = $("#pageSize");
		pageSizeObj.val(select.options[select.options.selectedIndex].value);
		changePage(1);
	},
	/**
	 * 更改页面大小
	 * @param select 页面大小
	 */
	log : function(msg){
		console.log(msg);
	},
	
	/**
	 * 启用禁用button按钮
	 * @param btnObj Jquery的button对象
	 */
	btnStatusToggle : function(btnObj){
		if (btnObj) {
			if (btnObj.attr('disabled')) {//禁用状态 变为启用
				btnObj.removeAttr('disabled');
				btnObj.css('background','');
				btnObj.css('cursor','');
			}else{//启用状态 变为禁用
				btnObj.attr('disabled', true);
				btnObj.css('background','#DBDADB');
				btnObj.css('cursor','default');
			}
		}
	},
	/**
	 * 启用按钮
	 */
	btnStatusEnable : function(btnObj){
		if (btnObj) {
			btnObj.removeAttr('disabled');
			btnObj.css('background','');
			btnObj.css('cursor','');
		}
	},
	/**
	 * 禁用按钮
	 */
	btnStatusDisable : function(btnObj){
		if (btnObj) {
			btnObj.attr('disabled', true);
			btnObj.css('background','#DBDADB');
			btnObj.css('cursor','default');
		}
	},
	/**
	 * 主iframe高度适应
	 * subFrameId 如果有子iframe，先适应子iframe高度
	 */
	mainFrameAutoHeight : function(subFrameId){
		if (subFrameId) {
			var subFrame = $('#'+subFrameId,window.parent.document);
			if (subFrame.length == 0) {
				subFrame = $('#'+subFrameId);
			}
			var subFrameH = subFrame.contents().find('body').height() + 30;
			if (subFrameH < 900) {
				this.log("内容高度为"+subFrameH+",默认最小高度：900");
				subFrameH = 900;
			}
			subFrame.height(subFrameH);
			this.log("subFrameAutoHeight="+subFrameH);
		}
		var mainFrame = $('#mainFrame', window.parent.parent.document);
		if (mainFrame.length == 0) {
			mainFrame = $('#mainFrame', window.parent.document);
		}
		var mainFrameH = mainFrame.contents().find('body').height() + 30;
		this.log("mainFrameAutoHeight="+mainFrameH);
		mainFrame.height(mainFrameH); 
	},
	/**
	 * 全部替换
	 * sourceStr 原始字符换
	 * oldStr 要替换的原字符串
	 * newStr 要替换的新字符串
	 */
	replaceAll : function(sourceStr, oldStr, newStr){
        while (sourceStr.indexOf(oldStr) >= 0){
        	sourceStr = sourceStr.replace(oldStr, newStr);
        }
        return sourceStr;
	},
	/**
	 * 精度安全的浮点计算
	 */
	doubleAdd : function (arg1,arg2){
	    var r1,r2,m;
	    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
	    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
	    m=Math.pow(10,Math.max(r1,r2));
	    return (arg1*m+arg2*m)/m;
	},
	/**
	 * 进度安全的浮点计算
	 */
	accSubtr : function (arg1,arg2){
		var r1,r2,m,n;
		try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
		try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
		m=Math.pow(10,Math.max(r1,r2));
		//动态控制精度长度
		n=(r1>=r2)?r1:r2;
		return ((arg1*m-arg2*m)/m).toFixed(n);
	},
	showLoadMask : function(){
		var mask = $('.loading-pic');
		if (mask || mask.length == 1) {
			mask.show();
		}
	},
	hideLoadMask : function(){
		var mask = $('.loading-pic');
		if (mask || mask.length == 1) {
			mask.hide();
		}
	},
	zTreeCheckNodes : function(treeObj,nodeIdArray){
		if (treeObj && nodeIdArray) {
			for (var i = 0; i < nodeIdArray.length; i++) {
				var node = treeObj.getNodesByParam('id',nodeIdArray[i]);
				if (node && node.length > 0) {
					treeObj.checkNode(node[0], true, true);
				}
			}
		}
	}
});


