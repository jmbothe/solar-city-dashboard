import React, { Component } from 'react';
import RegionDetails from './RegionDetails';
import ProjectsList from './ProjectsList';

class DashSidebar extends Component {
  state = {}
  render() {
    return (
      <nav>
      <RegionDetails
        region={this.props.region}
        management={this.props.management}
      />
      <ProjectsList
        projects={this.props.projects}
      />
      </nav>
    )
  }
}
 
export default DashSidebar;