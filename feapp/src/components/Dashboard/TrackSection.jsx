import React, { useState, useEffect } from 'react';
import './TrackSection.css';

const TrackSection = () => {
  const [trackEvents, setTrackEvents] = useState([]);
  const [selectedPatient, setSelectedPatient] = useState(null);
  const [patientHistory, setPatientHistory] = useState([]);

  // In a real application, this would fetch data from an API
  useEffect(() => {
    // Mock data for demonstration
    const mockTrackEvents = [
      {
        id: 1,
        name: '葉安翰',
        genderAge: '男/42',
        condition: '腦中風後恢復期',
        therapistInfo: '物理治療/陳醫師',
        currentTraining: '上肢協調性訓練計畫',
        status: '進行中'
      },
      {
        id: 2,
        name: '林美玲',
        genderAge: '女/35',
        condition: '焦慮症',
        therapistInfo: '心理治療/王醫師',
        currentTraining: '放鬆技巧訓練',
        status: '進行中'
      }
    ];
    
    const mockHistory = [
      {
        date: '2024/12/11',
        description: '完成本週第一次訓練',
        isAbnormal: false
      },
      {
        date: '2024/12/12',
        description: '完成本週第二次訓練',
        isAbnormal: false
      },
      {
        date: '2024/12/13',
        description: '訓練狀態異常',
        isAbnormal: true
      }
    ];

    setTrackEvents(mockTrackEvents);
    // Default to first patient's history
    setPatientHistory(mockHistory);
  }, []);

  const handleTrackRowClick = (patient) => {
    setSelectedPatient(patient);
    // In a real app, this would fetch the history for the selected patient
    // For now we'll reuse the same mock history
  };

  return (
    <div className="default-blks track-blks">
      <div className="col-9 default-blk track-blk">
        <div className="title">個案訓練進展</div>
        <table className="table table-fixed">
          <thead>
            <tr>
              <th className="col-xs-0-5">序</th>
              <th className="col-xs-1-5">姓名</th>
              <th className="col-xs-1-5">性別/年齡</th>
              <th className="col-xs-3">適應症</th>
              <th className="col-xs-2">領域/治療師</th>
              <th className="col-xs-2-5">目前訓練教案</th>
              <th className="col-xs-1">狀態</th>
            </tr>
          </thead>
          <tbody className="track-events">
            {trackEvents.length > 0 ? (
              trackEvents.map((event, index) => (
                <tr 
                  key={event.id}
                  className={selectedPatient && selectedPatient.id === event.id ? 'selected' : ''}
                  onClick={() => handleTrackRowClick(event)}
                >
                  <td className="col-xs-0-5">{index + 1}</td>
                  <td className="col-xs-1-5">{event.name}</td>
                  <td className="col-xs-1-5">{event.genderAge}</td>
                  <td className="col-xs-3">{event.condition}</td>
                  <td className="col-xs-2">{event.therapistInfo}</td>
                  <td className="col-xs-2-5">{event.currentTraining}</td>
                  <td className="col-xs-1">{event.status}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td className="col-xs-12">暫無訓練進展資訊</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
      
      <div className="arrow arrow-right" style={{ display: selectedPatient ? 'block' : 'none' }}></div>
      
      <div className="col-3 default-blk history-blk" style={{ display: selectedPatient ? 'block' : 'none' }}>
        <div className="title">
          <p>{selectedPatient ? selectedPatient.name : ''}</p>個案訓練歷程
        </div>
        <ul className="timeline">
          {patientHistory.map((item, index) => (
            <li key={index} className={item.isAbnormal ? 'abnormal' : ''}>
              <a>{item.date}</a>
              <p>{item.description}</p>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default TrackSection;