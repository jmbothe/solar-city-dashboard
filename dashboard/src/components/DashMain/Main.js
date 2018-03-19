import React, { Component } from 'react';
import ProjectView from './ProjectView';

class DashMain extends Component {
  state = {}
  render() { 
    return (
      <ProjectView
        project={this.props.projectInView}
        crew={this.props.crew.filter(member => member.assignedTo == this.props.projectInView.projectId)}
      />
    )
  }
}
 
export default DashMain;