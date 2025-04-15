import React, { useState, useEffect } from 'react';
import './Clock.css';

const Clock = () => {
  const [date, setDate] = useState('');
  const [day, setDay] = useState('');
  const [time, setTime] = useState('');

  // Format functions
  const formatDate = (date) => {
    return `${date.getFullYear()}/${String(date.getMonth() + 1).padStart(2, '0')}/${String(date.getDate()).padStart(2, '0')}`;
  };

  const formatDay = (date) => {
    const days = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    return days[date.getDay()];
  };

  const formatTime = (date) => {
    return `${String(date.getHours()).padStart(2, '0')}:${String(date.getMinutes()).padStart(2, '0')}`;
  };

  // Update clock every minute
  useEffect(() => {
    const updateTime = () => {
      const now = new Date();
      setDate(formatDate(now));
      setDay(formatDay(now));
      setTime(formatTime(now));
    };
    
    // Initial update
    updateTime();
    
    // Schedule updates to sync with the beginning of each minute
    const now = new Date();
    const secondsUntilNextMinute = 60 - now.getSeconds();
    const timerId = setTimeout(() => {
      updateTime();
      setInterval(updateTime, 60000); // Update every minute after that
    }, secondsUntilNextMinute * 1000);
    
    return () => {
      clearTimeout(timerId);
    };
  }, []);

  return (
    <div className="time-blk">
      <div className="time-content">
        <div className="date">{date}</div>
        <div className="day">{day}</div>
      </div>
      <div className="time-content">
        <div className="time">{time}</div>
      </div>
    </div>
  );
};

export default Clock;