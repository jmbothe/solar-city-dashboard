import React, { Component } from 'react';
import CrewMemberCard from './CrewMemberCard/CrewMemberCard';

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

    const filteredCrew =
    this.state.assignmentView
      ? crew.filter(member => !member.assignedTo)
      : crew.filter(member => member.assignedTo == projectInView.projectId);

  return (
    <section className="crew-list-tile">
    <div className="tile-heading">
      <h3>{this.state.assignmentView ? 'Available Crew' : 'Assigned Crew'}</h3>
      </div>
      <div className="crew-toggle-container">
      <button
        onClick={this.toggleAssignmentView}
      >
        {this.state.assignmentView ? 'View Assigned Crew' : 'View Available Crew'}
      </button>
      </div>
      <div className="crew-list-wrapper">
        <ul className="crew-list">
          {filteredCrew.map(member =>
            <CrewMemberCard
              key={member.employeeId}
              member={member}
              assignCrewMember={this.props.assignCrewMember}
              assignmentView={this.state.assignmentView}
              projectInView={this.props.projectInView}
            />
          )}
        </ul>
      </div>
    </section>
  )
  }
}
 
export default ProjectCrew;