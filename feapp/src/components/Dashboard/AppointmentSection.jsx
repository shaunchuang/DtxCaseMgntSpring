import React, { useState, useEffect } from 'react';
import Clock from './Clock';
import './AppointmentSection.css';

const AppointmentSection = () => {
  const [appointmentEvents, setAppointmentEvents] = useState([]);
  const [dashboardStats, setDashboardStats] = useState({
    todayAppointments: 0,
    updatedCases: 0,
    abnormalCases: 0
  });

  // In a real application, this would fetch data from an API
  useEffect(() => {
    // Mock data - in a real app, this would come from a backend API
    // setAppointmentEvents(fetchedData);
  }, []);

  return (
    <div className="default-blks appointment-blks">
      <div className="col-8 default-blk appointment-blk">
        <div className="title">今日個案預約行程</div>
        <table className="table table-fixed">
          <thead>
            <tr>
              <th className="col-xs-0-5">序</th>
              <th className="col-xs-1">類型</th>
              <th className="col-xs-1-5">患者姓名</th>
              <th className="col-xs-1-5">性別/年齡</th>
              <th className="col-xs-4">適應症</th>
              <th className="col-xs-1-5">預約時間</th>
              <th className="col-xs-2">報到狀態</th>
            </tr>
          </thead>
          <tbody className="appointment-events">
            {appointmentEvents.length > 0 ? (
              appointmentEvents.map((event, index) => (
                <tr key={index}>
                  <td className="col-xs-0-5">{index + 1}</td>
                  <td className="col-xs-1">{event.type}</td>
                  <td className="col-xs-1-5">{event.patientName}</td>
                  <td className="col-xs-1-5">{event.genderAge}</td>
                  <td className="col-xs-4">{event.condition}</td>
                  <td className="col-xs-1-5">{event.appointmentTime}</td>
                  <td className="col-xs-2">
                    <button 
                      data-case={event.caseNo}
                      data-slot={event.slot}
                      className="badge-checkin"
                    >
                      {event.status}
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td className="col-xs-12">暫無看診資訊</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      <div className="col-4">
        <Clock />
        <div className="default-blk dashboard-blk">
          <div className="d-column d-today-column">
            <span className="d-title">今日預約個案</span>
            <span>待報到人數：<p>{dashboardStats.todayAppointments}</p> 位</span>
          </div>
          <div className="d-column d-update-column">
            <span className="d-title">歷程更新個案</span>
            <span>待檢視人數：<p>{dashboardStats.updatedCases}</p> 位</span>
          </div>
          <div className="d-column d-abnormal-column">
            <span className="d-title">訓練異常個案</span>
            <span>待檢視人數：<p>{dashboardStats.abnormalCases}</p> 位</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AppointmentSection;