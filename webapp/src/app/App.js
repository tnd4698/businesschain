import React, { Component } from 'react';
import { Container } from 'reactstrap';
import { Switch, Route, Redirect } from 'react-router-dom';
import Header from './common/Header/Header';
import Sidebar from './common/Sidebar/Sidebar';
import Footer from './common/Footer/Footer';
import { connect } from 'react-redux';


import { default as BillComponent } from './bill/BillContainer'
import {default as TuitionComponent} from './tuition/TuitionContainer'
import {default as EmployeesComponent} from './employees/EmployeesContainer'
import {default as TimeworksComponent} from './timeworks/TimeworksContainer'
import {default as ResourcesComponent} from './resources/ResourceContainer'
import {default as StudentsComponent} from './students/StudentContainer'
import {default as ClassesComponent} from './classes/ClassesContainer'
import {default as BranchDetailComponent} from './branchDetail/BranchDetailContainer'
import {default as ImportComponent} from './import/ImportContainer'
import {default as ShipwayComponent} from './shipway/ShipwayContainer'
import {default as BranchesComponent} from './branches/BranchesContainer'
import {default as SpendComponent} from './spend/SpendContainer'
import {default as PayrollsComponent} from './payrolls/PayrollsContainer'
import {default as BillReportComponent} from './billReport/BillReportContainer'
import {default as PayrollReportComponent} from './payrollReport/PayrollReportContainer'
import {default as ProfitReportComponent} from './profitReport/ProfitReportContainer'
import {default as TuitionReportComponent} from './tuitionReport/TuitionReportContainer'
import {default as HomeComponent} from './home/HomeContainer'


class App extends Component {

  render() {
    return (
      <div className="app">
        <Header />
        <div className="app-body">
          <Sidebar {...this.props} />
          <main className="main">
            <Container fluid>
              <Switch>
                {
                  this.props.role !== '[ROLE_ANONYMOUS]' && [
                    <Route path="/bill" name="BillComponent" component={BillComponent} />,
                    <Route path="/tuition" name="TuitionComponent" component={TuitionComponent} />,
                    <Route path="/employees" name="EmployeesComponent" component={EmployeesComponent} />,
                    <Route path="/timeworks" name="TimeworksComponent" component={TimeworksComponent} />,
                    <Route path="/resources" name="ResourcesComponent" component={ResourcesComponent} />,
                    <Route path="/students" name="StudentsComponent" component={StudentsComponent} />,
                    <Route path="/classes" name="ClassesComponent" component={ClassesComponent} />,
                    <Route path="/branchs/:id" name="BranchDetailComponent" component={BranchDetailComponent} />,
                    <Route path="/import" name="ImportComponent" component={ImportComponent} />,
                    <Route path="/shipway" name="ShipwayComponent" component={ShipwayComponent} />,
                    <Route path="/branches" name="BranchesComponent" component={BranchesComponent} />,
                    <Route path="/spend" name="SpendComponent" component={SpendComponent} />,
                    <Route path="/payrolls" name="PayrollsComponent" component={PayrollsComponent} />,
                    <Route path="/bill-report" name="BillReportComponent" component={BillReportComponent} />,
                    <Route path="/payroll-report" name="PayrollReportComponent" component={PayrollReportComponent} />,
                    <Route path="/profit-report" name="ProfitReportComponent" component={ProfitReportComponent} />,
                    <Route path="/tuition-report" name="TuitionReportComponent" component={TuitionReportComponent} />,
                    <Route path="/profile" name="HomeComponent" component={HomeComponent} />,
                    <Redirect from="/" to="/profile" />
                  ]
                }
                {
                  this.props.role === '[ROLE_ANONYMOUS]' && [

                    <Redirect from="/" to="/login" />
                  ]
                }
              </Switch>
            </Container>
          </main>
        </div>
        <Footer />
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
      role : state.home.role
  }
}

export default connect(
  mapStateToProps,
  null
)(App);