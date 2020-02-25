import {Component, OnInit, ViewChild} from '@angular/core';
import {PaginatorComponent} from 'shared-lib';
import {DomainRpc} from 'domain-lib';
import {ActivatedRoute, Router} from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-domains',
  templateUrl: './domains.component.html',
  styleUrls: ['./domains.component.css']
})
export class DomainsComponent implements OnInit {
  displayedColumns = ['actions', 'name'];
  dataSource: MatTableDataSource<DomainRpc>;
  selectedItem: DomainRpc;

  @ViewChild(PaginatorComponent, { static: true }) paginator: PaginatorComponent;

  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(private router: Router,
              private route: ActivatedRoute,
              public snackBar: MatSnackBar) { }


  ngOnInit() {
    this.route.data
      .subscribe((data: {resp: DomainRpc[]}) => {
          this.dataSource = new MatTableDataSource(data.resp);
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator.paginator;
        },
        error => this.snackBar.open(
          'Failed to load domains',
          'Dismiss',
          {duration: 5000}
        )
      );
  }

  doFilter(val: string) {
    if (!this.dataSource) { return; }
    this.dataSource.filter = val;
  }

  view(domain: string) {
    this.router.navigate(['registry/services', domain]);
  }

  createService() {
    this.router.navigate(['form/edit/-1']);
  }
}
