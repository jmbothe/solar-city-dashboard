import React, { Component } from 'react';
import ProjectTiles from './ProjectTiles/ProjectTiles';
import ProjectTimeline from './ProjectTimeline';

class ProjectView extends Component {
  state = {}
  render() { 
    return (
      <section className="project-view">
        <ProjectTimeline
          project={this.props.project}
          toggleMilestone={this.props.toggleMilestone}
        />
        <ProjectTiles
          project={this.props.project}
          crew={this.props.crew}
          unassignCrewMember={this.props.unassignCrewMember}
          assignCrewMember={this.props.assignCrewMember}
          updateNotes={this.props.updateNotes}
          changeNotes={this.props.changeNotes}
        />
      </section>
    )
  }
}
 
export default ProjectView;