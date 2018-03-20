import React, { Component } from 'react';

class CrewList extends Component {

  handleUnassignClick = (id) => {
    this.props.assignCrewMember(id);
  }
  
  render() { 
    return (
      <section className="crew-list-tile">
      <div className="tile-heading">
        <h3>Assigned Crew</h3>
        </div>
        <div className="crew-toggle-container">
        <button
          onClick={this.props.toggleAssignmentView}
        >
          View Available Crew
        </button>
        </div>
        <div className="crew-list-wrapper">
          <ul className="crew-list">
            {this.props.crew.map(member =>
              
              <li
                key={member.employeeId}
                className="crew-list-item"
              >
                <div>
                  {member.firstName} {member.lastName}
                  <br/>
                  {member.phoneNumber}
                  <br/>
                  {
                    <a
                      href={`mailto:${member.email}`}
                      target="_blank" rel="noopener noreferrer"
                      >
                        {member.email}
                    </a>
                  }
                  </div>
                <div className="crew-list-item-button-wrapper">
                  <button onClick={() => this.handleUnassignClick(member.employeeId)}>Remove</button>
                </div>
              </li>
            )}
          </ul>
        </div>
      </section>
    )
  }
}
 
export default CrewList;