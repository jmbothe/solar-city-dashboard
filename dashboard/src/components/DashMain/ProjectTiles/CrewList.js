import React, { Component } from 'react';

class CrewList extends Component {

  handleUnassignClick = (id) => {
    this.props.unassignCrewMember(id);
  }
  
  render() { 
    return (
      <section className="crew-list-tile">
        <h3>Crew</h3>
        <div className="crew-list-wrapper">
          <ul className="crew-list">
            {this.props.crew.map(member =>
              
              <li
                key={member.employeeId}
                className="crew-list-item"
              >
                <div>
                  {member.employeeId} {member.firstName} {member.lastName}
                  <br/>
                  {member.phoneNumber}
                  {
                    <a
                      href={`mailto:${member.email}`}
                      target="_blank" rel="noopener noreferrer"
                      >
                        {member.email}
                    </a>
                  }
                  </div>
                <div>
                  <button onClick={() => this.handleUnassignClick(member.employeeId)}>Remove</button>
                </div>
              </li>
            )}
            <li>
              <button
                onClick={this.props.toggleAssignmentView}
              >
                assign more crew members to this project
              </button>
            </li>
          </ul>
        </div>
      </section>
    )
  }
}
 
export default CrewList;