import React, { Component } from 'react';
import CrewList from './CrewList'
import AssignmentView from './AssignmentView'

class ProjectCrew extends Component {
  state = {
    assignmentView: false
  }

  toggleAssignmentView = () => 
    this.setState({assignmentView: !this.state.assignmentView});

  render() {
    const {
      projectInView,
      crew,
      assignCrewMember
    } = this.props;

    return (
      <CrewList
        crew={
          this.state.assignmentView
          ? crew.filter(member => !member.assignedTo)
          : crew.filter(member => member.assignedTo == projectInView.projectId)
          }
        assignCrewMember={assignCrewMember}
        toggleAssignmentView={this.toggleAssignmentView}
        assignmentView={this.state.assignmentView}
        projectInView={projectInView}
      />
    )
  }
}
 
export default ProjectCrew;