import React, { Component } from 'react';
import Main from './DashMain/Main';
import Sidebar from './DashSidebar/Sidebar';

class Dashboard extends Component {
  state = {
    region: {id: 1, name: "Mid-Atlantic"},
  }

  async componentDidMount() {
    try {
      const employeesResponse = await fetch(`http://localhost:8080/employees/by-region/${this.state.region.id}`);
      const employees = await employeesResponse.json();
      const projectsResponse = await fetch(`http://localhost:8080/projects/by-region/${this.state.region.id}`)
      const projects = await projectsResponse.json();

      const management = {
        projectManager: employees.find(employee => employee.position.id == 1),
        projectCoordinator: employees.find(employee => employee.position.id == 2),
        constructionManager: employees.find(employee => employee.position.id == 3),
      };
      const crew = employees.filter(employee => employee.position.id == 4);

      this.setState({management, crew, projects, projectInView: projects[0]})
    } catch (error) {
      console.log('error getting employee and project info')
    }
  }

  render() {
    if (!this.state.crew) {
      return <div></div>
    } else {
    return (
      <div className="dashboard-wrapper">
        <header>
          <h1>Solar City Project Manager Dashboard</h1>
        </header>
        <section className="dashboard">
            <Sidebar
              region={this.state.region}
              management={this.state.management}
              projects={this.state.projects}
              projectInView={this.state.projectInView}
            />
            <Main
              projects={this.state.projects}
              projectInView={this.state.projectInView}
              crew={this.state.crew}
            />
          </section>
        </div>
      )
    }
  }
}
 
export default Dashboard;