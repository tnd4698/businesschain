import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import {Badge, Nav, NavItem, NavLink as RsNavLink} from 'reactstrap';
import classNames from 'classnames';
import nav from './_nav';
import SidebarMinimizer from './SidebarMinimizer';
import { connect } from 'react-redux';

class Sidebar extends Component {

  constructor(props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
    this.activeRoute = this.activeRoute.bind(this);
    this.hideMobile = this.hideMobile.bind(this);
  }


  handleClick(e) {
    e.preventDefault();
    e.target.parentElement.classList.toggle('open');
  }

  activeRoute(routeName, props) {
    return props.location.pathname.indexOf(routeName) > -1 ? 'nav-item nav-dropdown open' : 'nav-item nav-dropdown';

  }

  hideMobile() {
    if (document.body.classList.contains('sidebar-mobile-show')) {
      document.body.classList.toggle('sidebar-mobile-show')
    }
  }

  render() {

    const props = this.props;

    const badge = (badge) => {
      if (badge) {
        const classes = classNames( badge.class );
        return (<Badge className={ classes } color={ badge.variant }>{ badge.text }</Badge>)
      }
    };

    const wrapper = item => { return (item.wrapper && item.wrapper.element ? (React.createElement(item.wrapper.element, item.wrapper.attributes, item.name)): item.name ) };

    const title =  (title, key) => {
      const classes = classNames( 'nav-title', title.class);
      return (<li key={key} className={ classes }>{wrapper(title)} </li>);
    };

    const divider = (divider, key) => {
      const classes = classNames( 'divider', divider.class);
      return (<li key={key} className={ classes }></li>);
    };

    const navItem = (item, key) => {
      const classes = {
        item: classNames( item.class) ,
        link: classNames( 'nav-link', item.variant ? `nav-link-${item.variant}` : ''),
        icon: classNames( item.icon )
      };
      return (
        navLink(item, key, classes)
      )
    };

    const navLink = (item, key, classes) => {
      const url = item.url ? item.url : '';
      return (
        <NavItem key={key} className={classes.item}>
          { isExternal(url) ?
            <RsNavLink href={url} className={classes.link} active>
              <i className={classes.icon}></i>{item.name}{badge(item.badge)}
            </RsNavLink>
            :
            <NavLink to={url} className={classes.link} activeClassName="active" onClick={this.hideMobile}>
              <i className={classes.icon}></i>{item.name}{badge(item.badge)}
            </NavLink>
          }
        </NavItem>
      )
    };

    const navDropdown = (item, key) => {
      return (
        <li key={key} className={this.activeRoute(item.url, props)}>
          <a className="nav-link nav-dropdown-toggle" href="##" onClick={this.handleClick}><i className={item.icon}></i>{item.name}</a>
          <ul className="nav-dropdown-items">
            {navList(item.children)}
          </ul>
        </li>)
    };

    const navType = (item, idx) =>
      item.title ? title(item, idx) :
      item.divider ? divider(item, idx) :
      item.children ? navDropdown(item, idx)
                    : navItem(item, idx) ;

    const navList = (items) => {
      return items.map( (item, index) => navType(item, index) );
    };

    const isExternal = (url) => {
      const link = url ? url.substring(0, 4) : '';
      return link === 'http';
    };

    
    return (
      <div className="sidebar">
        <nav className="sidebar-nav">
          <Nav>
            {
              this.props.role==='[ROLE_BRANCHMANAGER]' && navList(nav.items1)
            }
            {
              this.props.role==='[ROLE_BUSINESSMANAGER]' && navList(nav.items2)
            }
            {
              this.props.role==='[ROLE_ACCOUNTANT]' && navList(nav.items3)
            }
          </Nav>
        </nav>
        <SidebarMinimizer/>
      </div>
    )
  }
}

const mapStateToProps = (state) => {
  const role = state.home.role;
  return {
    role
  }
};

export default connect(
  mapStateToProps,
  null
)(Sidebar);
