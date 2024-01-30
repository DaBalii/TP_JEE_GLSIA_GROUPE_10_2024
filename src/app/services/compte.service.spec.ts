import { TestBed } from '@angular/core/testing';

import { CompteService } from './compte.service';

describe('CompteService', () => {
  let service: CompteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
