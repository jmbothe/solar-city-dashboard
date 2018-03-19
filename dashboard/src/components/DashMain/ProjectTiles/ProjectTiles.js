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
          project={this.props.project}
          crew={this.props.crew}
        />
        <ProjectCrew
          crew={this.props.crew}
          unassignCrewMember={this.props.unassignCrewMember}
        />
        <ProjectNotes
          notes={this.props.project.notes}
        />
      </section>
    )
  }
}
 
export default ProjectTiles;