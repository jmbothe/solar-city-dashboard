import React, { Component } from 'react';
import ProjectTiles from './ProjectTiles/ProjectTiles';
import ProjectTimeline from './ProjectTimeline';

class ProjectView extends Component {
  state = {}
  render() { 
    return (
      <section className="project-view">
        <ProjectTimeline
          projectInView={this.props.projectInView}
          toggleMilestone={this.props.toggleMilestone}
        />
        <ProjectTiles
          projectInView={this.props.projectInView}
          project={this.props.project}
          crew={this.props.crew}
          assignCrewMember={this.props.assignCrewMember}
          updateNotes={this.props.updateNotes}
          changeNotes={this.props.changeNotes}
        />
      </section>
    )
  }
}
 
export default ProjectView;