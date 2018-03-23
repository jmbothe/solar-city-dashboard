import React, { Component } from 'react';
import Main from './DashMain/Main';
import Sidebar from './DashSidebar/Sidebar';

class Dashboard extends Component {
  state = {
    region: {id: 1, name: "Mid-Atlantic"},
  }

  // Set initial state based on employees and projects from Region
  async componentDidMount() {
    try {
      const employeesResponse = await fetch(`http://localhost:8080/employees/by-region/${this.state.region.id}`);
      const employees = await employeesResponse.json();
      const projectsResponse = await fetch(`http://localhost:8080/projects/by-region/${this.state.region.id}`)
      let projects = await projectsResponse.json();
      projects = projects.sort((a, b) => a.projectId - b.projectId)

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

  // Add or Remove crew member to/from assigned job
  assignCrewMember = async (id, projectId = null) => {
    try {
      await fetch(`http://localhost:8080/employees/assign/${id}`, {
        method: 'PATCH',
        body: JSON.stringify({assignedTo: projectId}),
        headers: {'Content-Type': 'application/json'},
      });
      const crew = [...this.state.crew];
      crew.find(member => member.employeeId == id).assignedTo = projectId;
      this.setState({crew});
    } catch (error) {
      console.log(`Error unassigning crew member ID${id} from job`)
      console.log(error)
    }
  }

  // Edit notes in State only for each keystroke
  changeNotes = (id, updatedNote) => {
    const projects = [...this.state.projects];
    projects.find(project => project.projectId == id).notes = updatedNote;
    this.setState({ projects });
  }

  // PATCH notes to backend on blur
  // TODO: if user leaves page before blur, notes dont get saved
  updateNotes = async (id) => {
    try {
      const notes = JSON.stringify(this.state.projects.find(project => project.projectId == id).notes);
      await fetch(`http://localhost:8080/projects/edit-notes/${id}`, {
        method: 'PATCH',
        body: JSON.stringify({notes}),
        headers: {'Content-Type': 'application/json'},
      })
    } catch (error) {
      console.log(`error updating notes for project ${id}`)
    }
  }

  // response to user interaction with timeline in project view
  toggleMilestone = async (id, milestoneName) => {
    try {
      const projects = [...this.state.projects];
      const project = projects.find(project => project.projectId == id)
      project[milestoneName] = !project[milestoneName];
      const response = await fetch(`http://localhost:8080/projects/toggle-milestones/${id}`, {
        method: 'PATCH',
        body: JSON.stringify(project),
        headers: {'Content-Type': 'application/json'},
      })
      this.setState({projects});
    } catch (error) {
      console.log(`error updating milestone for project ${id}`)
    }
  }

  // respond to user interaction with sidebar
  changeProjectInView = (id) => {
    this.setState({
      projectInView: this.state.projects.find(project => project.projectId == id)
    })
  }

  // TODO: Incorporrate POST and DELETE routes to front end.
  // Those routes already exist on backend, but not being used here on the frontend

  render() {
    return !this.state.crew
      ? <div></div>
      : (
        <div className="dashboard-wrapper">
          <header className="main-header">
            <h1>Solar City Project Manager Dashboard</h1>
            <h2>Region {this.state.region.id}, {this.state.region.name}</h2>
          </header>
          <section className="dashboard">
            <Sidebar
              region={this.state.region}
              management={this.state.management}
              projects={this.state.projects}
              projectInView={this.state.projectInView}
              changeProjectInView={this.changeProjectInView}
            />
            <Main
              projects={this.state.projects}
              projectInView={this.state.projectInView}
              crew={this.state.crew}
              assignCrewMember={this.assignCrewMember}
              updateNotes={this.updateNotes}
              changeNotes={this.changeNotes}
              toggleMilestone={this.toggleMilestone}
            />
          </section>
        </div>
      )
  }
}
 
export default Dashboard;