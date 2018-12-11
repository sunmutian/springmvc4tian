/**
 * 节点管理js
 */
var rMenu;  
$(function(){
   rMenu = $("#rMenu");
	//添加子节点
	$('#m_add').on('click',function(){
		hideMenu();
		$('.d_mask').load('toAdd',null,function(){
			var html = $(this).html();
			$.dialog({
				title:'添加子节点',
				id: 'add',
				lock: true,
				content: html,
				ok: function(){
					var selectNode = zTree.getSelectedNodes()[0];
					var nodeId = $('#nodeId',parent.document).val();
					var nodeData = $('#nodeData',parent.document).val();
					var param = {
						pId : selectNode.id,
						id : nodeId,
						data : nodeData
					};
					common.showLoadMask();
					common.ajaxPost('ajaxAddChildren',param,function(data){
						if(data.success){
							$.dialog.tips('添加成功');
							zTree.reAsyncChildNodes(selectNode, "refresh");
							zTree.selectNode(selectNode);
							zTree.setting.callback.onClick(null, zTree.setting.treeId, selectNode);
							//var nodeId = data.message;
							//var nodeName = nodeId.substring(nodeId.lastIndexOf('/')+1);
							//zTree.addNodes(selectNode,{id:nodeId, pId:selectNode.id, name:nodeName});
						}else{
							$.dialog.tips(data.message);
						}
						common.hideLoadMask();
					});
			    },
			    cancelVal: '关闭',
			    cancel: function(){
			    	
			    }
			});
		});
	});
	//删除子节点
	$('#m_del').on('click',function(){
		hideMenu();
		var selectNode = zTree.getSelectedNodes()[0];
		var param = {
				fullId : selectNode.id
		};
		common.showLoadMask();
		$.dialog.confirm('确定要删除这个节点吗？', function(){
			common.ajaxPost('ajaxDelNodeByFullId',param,function(data){
				if(data.success){
					var parentNode = selectNode.getParentNode();
					zTree.reAsyncChildNodes(parentNode, "refresh");
					zTree.selectNode(parentNode);
					zTree.setting.callback.onClick(null, zTree.setting.treeId, parentNode);
					$.dialog.tips('删除成功');
				}else{
					$.dialog.tips(data.message);
				}
				common.hideLoadMask();
			});
		}, function(){
		    
		});
	});
	//修改子节点
	$('#m_edit').on('click',function(){
		hideMenu();
		var selectNode = zTree.getSelectedNodes()[0];
		var param = {
				fullId : selectNode.id,
		};
		$('.d_mask').load('toEdit',param,function(){
			var html = $(this).html();
			$.dialog({
				title:'修改节点',
				id: 'edit',
				lock: true,
				content: html,
				ok: function(){
			    	var nodeId = $('#nodeId',parent.document).val();
					var nodeData = $('#nodeData',parent.document).val();
					var fullId = $('#fullId',parent.document).val();
					var param = {
							fullId : fullId,
							data : nodeData
					};
					common.showLoadMask();
					common.ajaxPost('ajaxEditNodeById',param,function(data){
						if(data.success){
							var parentNode = selectNode.getParentNode();
							zTree.selectNode(parentNode);
							zTree.setting.callback.onClick(null, zTree.setting.treeId, parentNode);
							$.dialog.tips('修改成功');
						}else{
							$.dialog.tips(data.message);
						}
						common.hideLoadMask();
					});
			    },
			    cancelVal: '关闭',
			    cancel: function(){
			    }
			});
		});
	});
});
  /**
   * 显示数节点菜单
   * @param type
   * @param x
   * @param y
   */
  function showRMenu(type, x, y) {
		$("#rMenu ul").show();
		rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});
		
		$("body").bind("mousedown", function(event){
			if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
				hideMenu();
			}
		});
  }
  /**
   * 隐藏树节点菜单
   */
  function hideMenu(){
		rMenu.css({"visibility" : "hidden"});
  }
