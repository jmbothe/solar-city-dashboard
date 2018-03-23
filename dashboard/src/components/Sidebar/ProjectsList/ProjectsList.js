import React from 'react';

const ProjectsList = ({projects, projectInView, changeProjectInView}) => 
  <section>
    <ul className="projects-list-ul">
      {projects.map(project => 
        <li key={project.projectId}>
          <button
            onClick={() => changeProjectInView(project.projectId)}
          >
            <span>{project.client} {project.projectName}</span>
            <span className="arrow">{projectInView == project ? '→' : '' }</span>
          </button>
        </li>
      )}
    </ul>
  </section>

export default ProjectsList;
