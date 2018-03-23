import React, { Component } from 'react';
import CrewMemberCard from './CrewMemberCard';

class CrewList extends Component {
  
  render() { 
    return (
      <section className="crew-list-tile">
      <div className="tile-heading">
        <h3>{this.props.assignmentView ? 'Available Crew' : 'Assigned Crew'}</h3>
        </div>
        <div className="crew-toggle-container">
        <button
          onClick={this.props.toggleAssignmentView}
        >
          {this.props.assignmentView ? 'View Assigned Crew' : 'View Available Crew'}
        </button>
        </div>
        <div className="crew-list-wrapper">
          <ul className="crew-list">
            {this.props.crew.map(member =>
              <CrewMemberCard
                key={member.employeeId}
                member={member}
                assignCrewMember={this.props.assignCrewMember}
                assignmentView={this.props.assignmentView}
                projectInView={this.props.projectInView}
              />
            )}
          </ul>
        </div>
      </section>
    )
  }
}
 
export default CrewList;