import React, { Component } from 'react';
import RegionDetails from './RegionDetails';
import ProjectsList from './ProjectsList';

class DashSidebar extends Component {
  state = {}
  render() {
    return (
      <nav className="sidebar">
      <RegionDetails
        region={this.props.region}
        management={this.props.management}
      />
      <ProjectsList
        projects={this.props.projects}
        changeProjectInView={this.props.changeProjectInView}
      />
      </nav>
    )
  }
}
 
export default DashSidebar;