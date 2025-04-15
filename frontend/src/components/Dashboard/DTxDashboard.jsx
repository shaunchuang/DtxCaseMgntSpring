import React, { useState, useEffect } from 'react';
import Sidebar from './Sidebar';
import TopBar from './TopBar';
import SubBar from './SubBar';
import AppointmentSection from './AppointmentSection';
import TrackSection from './TrackSection';
import './common.css';

const DTxDashboard = () => {
    // State for the sidebar toggle
    const [sidebarActive, setSidebarActive] = useState(true);

    // Function to toggle sidebar
    const toggleSidebar = () => {
        setSidebarActive(!sidebarActive);
    };

    // Adjust content height based on topbar and subbar
    useEffect(() => {
        function adjustHeight() {
            const containerHeight = document.querySelector('.content-blk').clientHeight;
            const topHeight = document.querySelector('.top-bar').offsetHeight;
            const subHeight = document.querySelector('.sub-bar').offsetHeight;
            const cntHeight = containerHeight - topHeight - subHeight;

            document.querySelector('.main-content').style.height = `${cntHeight}px`;
        }

        adjustHeight();
        window.addEventListener('resize', adjustHeight);

        // Cleanup event listener on component unmount
        return () => {
            window.removeEventListener('resize', adjustHeight);
        };
    }, []);

    return (
        <div>
            <div className={`sidebar ${sidebarActive ? 'active' : ''}`}>
                <Sidebar toggleSidebar={toggleSidebar} />
            </div>
            
            <div className={`content-blk`} style={{
                width: sidebarActive ? 'calc(100% - 180px)' : 'calc(100% - 63px)',
                left: sidebarActive ? '180px' : '63px'
            }}>
                <TopBar />
                <div className="custom-blk">
                    <SubBar />
                    <div className="clearfix"></div>
                    <div className="main-content">
                        <AppointmentSection />
                        <TrackSection />
                    </div>
                </div>
            </div>
            
            {/* Archive Patient Modal */}
            <div className="modal fade" id="archiveModal" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                <div className="modal-dialog" style={{width: '400px'}}>
                    <div className="modal-content">
                        <div className="modal-header">
                            切換歸檔個案
                            <button type="button" className="close clean" data-dismiss="modal" data-form="0" aria-label="Close">
                                <i className="fa fa-xmark" aria-hidden="true"></i>
                            </button>
                        </div>
                        <div className="modal-body">
                            <table className="info info-style-2" style={{width: '100%'}}>
                                <tbody>
                                    <tr>
                                        <td>個案選擇</td>
                                        <td>
                                            <select className="form-control patient-code" />
                                        </td>						
                                    </tr>
                                </tbody>
                            </table>             
                        </div>
                        <div className="modal-footer">         
                            <button className="func-btn" onClick={() => alert('updateArchiveInfo')}>更新</button>
                            <button className="clean func-btn" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default DTxDashboard;