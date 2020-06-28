<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title></title>
		<style>
			*{
				margin: 0;
				padding: 0;
				box-sizing: border-box;
			}
			body{
				font-family: SimSun;
			}
			section{
				display:block;
				margin: 20px 10px;
			}
			.title{
				text-align: center;
			}
			.preface p{
				line-height: 30px;
			}
			.preface p.content{
				text-indent: 2em;
			}
			section > table{
				table-layout: fixed;
				width: 100%;
				margin: 20px 0px;
				text-align:center;
				word-wrap:break-word;
			}
			section table td{
				padding:5px 0px;
			}
		</style>
	</head>
	<body>
		<!-- 标题 start -->
		<section class="title">
			<h2>某报告</h2>
		</section>
		<!-- 标题 end -->

		<!-- 前言 start -->
		<section class="preface">
			<p>尊敬的用户：</p>
			<p class="content">内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容</p>
		</section>
		<!-- 前言 end -->

		<!-- 汇总统计信息 start -->
		<section class="count-info">
			<h4>汇总统计信息</h4>
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td>本月笔数</td>
					<td>近三个月数量对比</td>
				</tr>
				<tr>
					<td>${curr}</td>
					<td>
						<table width="80%" border="1" cellspacing="0" cellpadding="0" style="margin: 5px auto;">
							<tr>
								<td>${one}</td>
								<td>${two}</td>
								<td>${three}</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</section>
		<!-- 汇总统计信息 end -->

		<!-- 明细 start -->
		<section class="detail">
			<h4>明细</h4>
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td width="5%">序号</td>
					<td width="15%">列1</td>
					<td width="12%">列2</td>
					<td width="12%">列3</td>
					<td width="12%">列4</td>
					<td>列5</td>
				</tr>
				<#list detailList as ad>
					<tr>
						<td>${ad_index+1}</td>
						<td>${ad.column1}</td>
						<td>${ad.column2}</td>
						<td>${ad.column3}</td>
						<td>${ad.column4}</td>
						<td>${ad.column5}</td>
					</tr>
				</#list>
			</table>
		</section>
		<!-- 明细 end -->
	</body>
</html>
