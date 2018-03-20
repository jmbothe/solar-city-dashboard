import React, { Component } from 'react';
import RegionDetails from './RegionDetails';
import ProjectsList from './ProjectsList';

class DashSidebar extends Component {
  state = {
    projectListView: false,
  }

  enableProjectListView = () => {
    this.setState({projectListView: true})
  }

  disableProjectListView = () => {
    this.setState({projectListView: false})
  }

  render() {
    const content = (this.state.projectListView)
    ? <ProjectsList
        projectInView={this.props.projectInView}
        projects={this.props.projects}
        changeProjectInView={this.props.changeProjectInView}
      />
    : <RegionDetails
        region={this.props.region}
        management={this.props.management}
      />

    return (
      <nav className="sidebar">
        <header>
          <div
            onClick={this.disableProjectListView}
            className={this.state.projectListView ? 'light-grey inset-shadow-left' : '' }
          >
            <h2 >Core Team</h2>
          </div>
          <div
            onClick={this.enableProjectListView}
            className={this.state.projectListView ? '' : 'light-grey inset-shadow-right' }
          >
            <h2>Projects</h2>
          </div>
        </header>
       {content}
      </nav>
    )
  }
}
 
export default DashSidebar;