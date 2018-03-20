import React, { Component } from 'react';
import ProjectView from './ProjectView';

class DashMain extends Component {
  state = {}
  render() { 
    return (
      <ProjectView
        project={this.props.projectInView}
        crew={this.props.crew}
        unassignCrewMember={this.props.unassignCrewMember}
        assignCrewMember={this.props.assignCrewMember}
        updateNotes={this.props.updateNotes}
        changeNotes={this.props.changeNotes}
        toggleMilestone={this.props.toggleMilestone}
      />
    )
  }
}
 
export default DashMain;