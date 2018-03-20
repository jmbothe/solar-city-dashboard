import React, { Component } from 'react';
import CrewList from './CrewList'
import AssignmentView from './AssignmentView'

class ProjectCrew extends Component {
  state = {
    assignmentView: false
  }

  toggleAssignmentView = () => {
    this.setState({assignmentView: !this.state.assignmentView})
  }

  render() {
    if (this.state.assignmentView) {
      return (
        <AssignmentView
          project={this.props.project}
          crew={this.props.crew.filter(member => !member.assignedTo)}
          assignCrewMember={this.props.assignCrewMember}
          toggleAssignmentView={this.toggleAssignmentView}
        />
      )
    }
    return (
      <CrewList
        crew={this.props.crew.filter(member => member.assignedTo == this.props.project.projectId)}
        unassignCrewMember={this.props.unassignCrewMember}
        toggleAssignmentView={this.toggleAssignmentView}
      />
    )
  }
}
 
export default ProjectCrew;