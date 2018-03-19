import React, { Component } from 'react';

class ProjectsList extends Component {
  state = {}
  render() { 
    return (
      <section>
        <h2>Projects</h2>
        <ul>
          {this.props.projects.map(project => {
            return (
              <li key={project.projectId}>
              <button
                onClick={() => this.props.changeProjectInView(project.projectId)}
              >
              {project.client} {project.projectName}
              </button>
              </li>
            )
          })}
        </ul>
      </section>
    )
  }
}
 
export default ProjectsList;