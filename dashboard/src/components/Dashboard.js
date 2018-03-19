import React, { Component } from 'react';
import Main from './DashMain/Main';
import Sidebar from './DashSidebar/Sidebar';

class Dashboard extends Component {
  state = {}
  render() { 
    return (
      <div className="dashboard-wrapper">
        <header>
          <h1>Solar City Project Manager Dashboard</h1>
        </header>
        <section className="dashboard">
          <Sidebar />
          <Main />
        </section>
      </div>
    )
  }
}
 
export default Dashboard;