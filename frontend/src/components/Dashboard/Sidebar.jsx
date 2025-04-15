import React, { useState } from 'react';
import './Sidebar.css';

const Sidebar = ({ toggleSidebar }) => {
  const [activeMenu, setActiveMenu] = useState(0); // 當前活躍的主菜單索引

  // 處理菜單項點擊
  const handleMenuClick = (index) => {
    setActiveMenu(activeMenu === index ? -1 : index);
  };

  return (
    <>
      <div className="logo_content">
        <div className="logo">
          <div className="logo_name logo_itri"></div>
        </div>
        <i className="fa fa-bars" id="btn" onClick={toggleSidebar}></i>
      </div>
      <nav id="sitemaps">
        <ul className="nav_list">
          <li>
            <a href="#" className={activeMenu === 0 ? "active" : ""} onClick={() => handleMenuClick(0)}>
              <i className="fa fa-home"></i>
              <span className="links_name">平台首頁</span>
              <i className={`fa fa-caret-down ${activeMenu === 0 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 0 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/division/web/review">首頁總覽</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/patient/new">建立個案</a></li>
              <li><a href="#">預約掛號</a></li>
            </ul>
          </li>
          <li>
            <a href="#" className={activeMenu === 1 ? "active" : ""} onClick={() => handleMenuClick(1)}>
              <i className="fa fa-clipboard-list"></i>
              <span className="links_name">個案管理</span>
              <i className={`fa fa-caret-down ${activeMenu === 1 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 1 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/home">個案列表</a></li>
            </ul>
          </li>
          <li>
            <a href="#" className={activeMenu === 2 ? "active" : ""} onClick={() => handleMenuClick(2)}>
              <i className="fa fa-message"></i>
              <span className="links_name">協作溝通</span>
              <i className={`fa fa-caret-down ${activeMenu === 2 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 2 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/division/web/communication/chatroom">群組討論</a></li>
            </ul>
          </li>
          <li>
            <a href="#" className={activeMenu === 3 ? "active" : ""} onClick={() => handleMenuClick(3)}>
              <i className="fa fa-file-medical"></i>
              <span className="links_name">資料交換</span>
              <i className={`fa fa-caret-down ${activeMenu === 3 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 3 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/division/web/exchange/hcRecordMgnt">健保申報管理</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/exchange/ltcRecordMgnt">長照申報管理</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/exchange/fhir">FHIR醫資交換</a></li>
            </ul>
          </li>
          <li>
            <a href="#" className={activeMenu === 4 ? "active" : ""} onClick={() => handleMenuClick(4)}>
              <i className="fa fa-chart-line"></i>
              <span className="links_name">報表管理</span>
              <i className={`fa fa-caret-down ${activeMenu === 4 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 4 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/division/web/report/result">檢測報告</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/report/basic">基本報表</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/report/sectionIndex">單位指標</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/report/caseIndex">個案指標</a></li>
              <li><a href="#">教案分析</a></li>
            </ul>
          </li>
          <li>
            <a href="#" className={activeMenu === 5 ? "active" : ""} onClick={() => handleMenuClick(5)}>
              <i className="fa fa-gear"></i>
              <span className="links_name">行政管理</span>
              <i className={`fa fa-caret-down ${activeMenu === 5 ? "arrow-rotate" : ""}`}></i>
            </a>
            <ul className={`sub-menu ${activeMenu === 5 ? "show" : ""}`}>
              <li><a href="/wgnursing/zh_TW/division/web/admin/taskMgnt/personal">排程追蹤</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/admin/userRoleMgnt/role">角色用戶管理</a></li>
              <li><a href="/wgnursing/zh_TW/division/web/admin/other/phraseMgnt">其他設定管理</a></li>
            </ul>
          </li>
        </ul>
      </nav>
      <div className="intro_content">
        <span>DTx 1.0 © 2024 ITRI.</span>
      </div>
    </>
  );
};

export default Sidebar;