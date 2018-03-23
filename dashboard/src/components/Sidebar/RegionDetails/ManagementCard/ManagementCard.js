import React from 'react';

const ManagementCard = ({title, manager: {firstName, lastName, phoneNumber, email}}) =>
  <li>
    <span>{title}</span>
    <br/>
    {firstName} {lastName}
    <br/>
    {phoneNumber}
    <br/>
    {
      <a
        href={`mailto:${email}`}
        target="_blank" rel="noopener noreferrer"
        >
          {email}
      </a>
    }
  </li>
 
export default ManagementCard;