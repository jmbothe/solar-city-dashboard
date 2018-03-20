import React, { Component } from 'react';
import ProjectView from './ProjectView';

class DashMain extends Component {
  state = {}
  render() { 
    return (
      <ProjectView
        projectInView={this.props.projectInView}
        project={this.props.projectInView}
        crew={this.props.crew}
        assignCrewMember={this.props.assignCrewMember}
        updateNotes={this.props.updateNotes}
        changeNotes={this.props.changeNotes}
        toggleMilestone={this.props.toggleMilestone}
      />
    )
  }
}
 
export default DashMain;