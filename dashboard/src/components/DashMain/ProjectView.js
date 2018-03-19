import React, { Component } from 'react';
import ProjectTiles from './ProjectTiles/ProjectTiles';
import ProjectTimeline from './ProjectTimeline';

class ProjectView extends Component {
  state = {}
  render() { 
    return (
      <section className="project-view">
        <ProjectTimeline />
        <ProjectTiles
          project={this.props.project}
          crew={this.props.crew}
        />
      </section>
    )
  }
}
 
export default ProjectView;