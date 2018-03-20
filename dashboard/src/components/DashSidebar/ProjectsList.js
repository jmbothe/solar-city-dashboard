import React, { Component } from 'react';

class ProjectsList extends Component {
  state = {}
  render() { 
    return (
      <section>
        <ul className="projects-list-ul">
          {this.props.projects
          .sort((a, b) => a.projectId - b.projectId)
          .map(project => {
            return (
              <li key={project.projectId}>
              <button
                onClick={() => this.props.changeProjectInView(project.projectId)}
              >
                <span>{project.client} {project.projectName}</span>
                <span className="arrow">{this.props.projectInView == project ? '→' : '' }</span>
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