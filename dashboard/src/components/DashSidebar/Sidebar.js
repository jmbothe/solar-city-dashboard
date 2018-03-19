import React, { Component } from 'react';
import RegionDetails from './RegionDetails';
import ProjectsList from './ProjectsList';

class DashSidebar extends Component {
  state = {}
  render() { 
    return (
      <nav>
      <RegionDetails />
      <ProjectsList />
      </nav>
    )
  }
}
 
export default DashSidebar;