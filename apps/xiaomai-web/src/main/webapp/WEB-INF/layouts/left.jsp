<%@ page language="java" pageEncoding="UTF-8" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${basePath}/static/images/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><shiro:principal property="name"/></a></p>
          <a href="#"><i class="fa fa-circle text-success"></i> </a>
        </div>
      </div>
      
     
    
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
    
         
         
        <li class="treeview ${user_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>用户管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="${user_query_action }"><a href="${basePath}/admin/user"><i class="fa fa-circle-o"></i> 用户管理</a></li>
          <li class="${privilege_active }"><a href="${basePath}/admin/privilege"><i class="fa fa-circle-o"></i> 权限管理</a></li>
           <li class="${role_active }"><a href="${basePath}/admin/role"><i class="fa fa-circle-o"></i> 角色管理</a></li>
          </ul>
        </li>
        
     <li class="treeview ${custom_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>定制游</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="${contominfo }"><a href="${basePath}/admin/custom/getCustomInfo"><i class="fa fa-circle-o"></i>个人资料</a></li>
            <li class="${contom_play }"><a href="${basePath}/admin/custom/play/playList"><i class="fa fa-circle-o"></i>玩法管理</a></li>
            <li class="${contom_indent }"><a href="${basePath}/admin/custom/indent/indentList"><i class="fa fa-circle-o"></i>订单管理</a></li>
          <!--  <li><a href="${basePath}/admin/custom/indent/indentTotalList"><i class="fa fa-circle-o"></i>财务管理</a></li>-->  
          </ul>
        </li>
        
        <li class="treeview ${ticket_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>门票管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li  class="${ticket_li }"><a href="${basePath}/admin/ticket/ticketList"><i class="fa fa-circle-o"></i>门票管理</a></li>
             <li class="${ticket_indent_li }"><a href="${basePath}/admin/ticket/indent/indentList"><i class="fa fa-circle-o"></i>订单管理</a></li>
          <!--    <li><a href="${basePath}/admin/ticket/indent/indentTotalList"><i class="fa fa-circle-o"></i>财务管理</a></li>-->   
          </ul>
        </li>
     
           <li class="treeview ${meishi_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>美食管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
          <li  class="${category_active }"><a href="${basePath}/admin/cate/category"><i class="fa fa-circle-o"></i> 门店类别</a></li>
            <li  class="${cate_tab }" ><a href="${basePath}/admin/cate"><i class="fa fa-circle-o"></i> 门店管理</a></li>
            <li  class="${dish_active }" ><a href="${basePath}/admin/cate/dish"><i class="fa fa-circle-o"></i> 菜品管理</a></li>
           <li  class="${coupons_active }" ><a href="${basePath}/admin/cate/coupons"><i class="fa fa-circle-o"></i> 代金券管理</a></li>
            <li  class="${memebership_active }" ><a href="${basePath}/admin/cate/memebership"><i class="fa fa-circle-o"></i> 会员卡管理</a></li>
             <li  class="${payBill_active }" ><a href="${basePath}/admin/cate/payBill"><i class="fa fa-circle-o"></i> 买单管理</a></li>
             <li  class="${cate_order_active }" ><a href="${basePath}/admin/cate/order"><i class="fa fa-circle-o"></i> 订单管理</a></li>
          </ul>
        </li>
        
        <li class="treeview ${hotel_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>酒店管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
          <li  class="${hotel_info_active }"><a href="${basePath}/admin/hotel/info"><i class="fa fa-circle-o"></i> 酒店管理</a></li>
            <li  class="${hotel_facility_active }" ><a href="${basePath}/admin/hotel/facility"><i class="fa fa-circle-o"></i> 设施管理</a></li>
           <li  class="${hotel_room_active }" ><a href="${basePath}/admin/hotel/room"><i class="fa fa-circle-o"></i> 客房管理</a></li>
           <li  class="${hotel_order_active }" ><a href="${basePath}/admin/hotel/order"><i class="fa fa-circle-o"></i> 订单管理</a></li>
          </ul>
        </li>  
        
        
         <li class="treeview ${money_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>提现记录</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li  class="${money_m_active }"><a href="${basePath}/admin/withdrawalMonth/getPageWithdrawalMonthRecord"><i class="fa fa-circle-o"></i>月账单</a></li>
            <li  class="${money_r_active }"><a href="${basePath}/admin/indent/getPageWithdrawalRecord"><i class="fa fa-circle-o"></i>提现记录</a></li>
          </ul>
        </li>
        
        <li class="treeview ${advertising_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>广告管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
             <li  class="${advertising_active }"><a href="${basePath}/admin/advertising/list"><i class="fa fa-circle-o"></i>广告列表</a></li>
          </ul>
        </li>
        
         <li class="treeview ${backpacking_active }"  >
          <a href="#">
            <i class="fa fa-table"></i> <span>约伴管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
             <li  class="${backpacking_list }"><a href="${basePath}/admin/backpacking/list"><i class="fa fa-circle-o"></i>约伴列表</a></li>
          </ul>
        </li>
        
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

            