import React, { Component } from 'react';
import ProjectCrew from './ProjectCrew';
import ProjectDetails from './ProjectDetails';
import ProjectNotes from './ProjectNotes';

class ProjectTiles extends Component {
  state = {}
  render() { 
    return (
      <section className="project-tiles">
        <ProjectDetails
          projectInView={this.props.projectInView}
          crew={this.props.crew}
        />
        <ProjectCrew
          projectInView={this.props.projectInView}
          crew={this.props.crew}
          unassignCrewMember={this.props.unassignCrewMember}
          assignCrewMember={this.props.assignCrewMember}
        />
        <ProjectNotes
          projectInView={this.props.projectInView}
          updateNotes={this.props.updateNotes}
          changeNotes={this.props.changeNotes}
        />
      </section>
    )
  }
}
 
export default ProjectTiles;