/**
 * 欢迎页面
 * 
 */
Ext.onReady(function() {
			new Ext.ux.TipWindow({
						title : '<span class=commoncss>提示</span>',
						html : '您有[0]条未读信息.',
						iconCls : 'commentsIcon'
					}).show(Ext.getBody());
		});

Ext.onReady(function() {

	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

	var tools = [{
				id : 'maximize',
				handler : function(e, target, panel) {
				}
			}];

	var my_height1 = document.body.clientHeight - 35;
	var my_height = document.body.clientHeight - 65;
	var my_sina = '<div class=commoncss><iframe width="100%" height="' + my_height + '" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=zh_cn&width=0&height=' + my_height + '&fansRow=2&ptype=1&speed=300&skin=5&isTitle=0&noborder=0&isWeibo=1&isFans=0&uid=2756431474&verifier=3f8e70e3&dpc=1"></iframe></div>';
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [{
			xtype : 'portal',
			region : 'center',
			margins : '3 3 3 3',
			items : [{
						columnWidth : .6,
						style : 'padding:8px 0px 8px 8px',
						items : [{
									title : '新浪微博',
									layout : 'fit',
									// tools : tools,
									height : my_height1,
									html : my_sina
								}]
					}, {
						columnWidth : .4,
						style : 'padding:8px 8px 8px 8px',
						items : [{
							title : '联系方式',
							// tools : tools,
							html : '<div style=height:60px;line-height:25px class=commoncss>&nbsp;&nbsp;电子邮箱: g4it@qq.com<br>&nbsp;&nbsp;官方网站：<a href="http://www.g4it.org" target="_blank">www.g4it.org</a></div>'
						}, {
							title : '舍我其谁',
							// tools : tools,
							html : '<div style=height:155px;line-height:25px class=commoncss>&nbsp;&nbsp;如果G4Studio与你无缘, 那我推荐如下一些优秀的开发平台类产品. '
									+ ' <br>&nbsp;&nbsp;SpringSide：<a href="http://www.springside.org.cn" target="_blank">www.springside.org.cn</a>'
									+ ' <br>&nbsp;&nbsp;OperaMasks：<a href="http://www.operamasks.org" target="_blank">www.operamasks.org</a>'
									+ ' <br>&nbsp;&nbsp;AppFuse：<a href="http://www.appfuse.org" target="_blank">www.appfuse.org</a>'
									+ ' <br>&nbsp;&nbsp;JustepX5：<a href="http://www.justep.com" target="_blank">www.justep.com</a>'
									+ ' <br>&nbsp;&nbsp;Primeton EOS：<a href="http://www.primeton.com/products/bap" target="_blank">www.primeton.com</a>'
									+ ' </div>'
						}]
					}]
		}]
	});
});
