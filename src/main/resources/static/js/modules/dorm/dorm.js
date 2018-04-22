$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'dorm/dorm/list',
        datatype: "json",
        colModel: [			
			{ label: '序号', name: 'dormId', index: 'dorm_id', width: 50, key: true },
			{ label: '宿舍号', name: 'ssh', index: 'ssh', width: 80 },
            { label: '宿舍类型', name: 'type', width: 80, formatter: function(value, options, row){
                return value == 0 ?
                    '<span class="label label-info">女生宿舍</span>' :
                    '<span class="label label-info">男生宿舍</span>';
            }},
			{ label: '容纳的人数', name: 'rnrs', index: 'rnrs', width: 80 }, 			
			{ label: '入住人数', name: 'rzrs', index: 'rzrs', width: 80 }, 			
			{ label: '入住汉族人数', name: 'hzrs', index: 'hzrs', width: 80 },
            { label: '入住人', name: 'xs', index: 'xs', width: 120 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		dorm: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dorm = {};
		},
		update: function (event) {
			var dormId = getSelectedRow();
			if(dormId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(dormId)
		},
		saveOrUpdate: function (event) {
			var url = vm.dorm.dormId == null ? "dorm/dorm/save" : "dorm/dorm/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.dorm),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var dormIds = getSelectedRows();
			if(dormIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "dorm/dorm/delete",
                    contentType: "application/json",
				    data: JSON.stringify(dormIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(dormId){
			$.get(baseURL + "dorm/dorm/info/"+dormId, function(r){
                vm.dorm = r.dorm;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});