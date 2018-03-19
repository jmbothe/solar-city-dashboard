import React, { Component } from 'react';
import Main from './DashMain/Main';
import Sidebar from './DashSidebar/Sidebar';

class Dashboard extends Component {
  state = {
    regionId: 1,
    projectManager: null,
    projectCoordinator: null,
    constructionManager: null,
    crew: [],
    projects: [],
  }

  async componentDidMount() {
    try {
      const employeesResponse = await fetch(`http://localhost:8080/employees/by-region/${this.state.regionId}`);
      const employees = await employeesResponse.json();
      const projectsResponse = await fetch(`http://localhost:8080/projects/by-region/${this.state.regionId}`)
      const projects = await projectsResponse.json();

      this.setState({
        projectManager: employees.find(employee => employee.position.id == 1),
        projectCoordinator: employees.find(employee => employee.position.id == 2),
        constructionManager: employees.find(employee => employee.position.id == 3),
        crew: employees.filter(employee => employee.position.id == 4),
        projects
      })
    } catch (error) {
      console.log('error getting employee and project info')
    }
  }

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