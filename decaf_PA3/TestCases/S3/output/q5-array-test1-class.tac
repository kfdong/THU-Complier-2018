VTABLE(_A) {
    <empty>
    A
    _A.seta;
    _A.printA;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_A_New) {
memo ''
_A_New:
    _T3 = 8
    parm _T3
    _T4 =  call _Alloc
    _T5 = 0
    *(_T4 + 4) = _T5
    _T6 = VTBL <_A>
    *(_T4 + 0) = _T6
    return _T4
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T7 = 4
    parm _T7
    _T8 =  call _Alloc
    _T9 = VTBL <_Main>
    *(_T8 + 0) = _T9
    return _T8
}

FUNCTION(_A.seta) {
memo '_T0:4 _T1:8'
_A.seta:
    _T10 = *(_T0 + 4)
    *(_T0 + 4) = _T1
}

FUNCTION(_A.printA) {
memo '_T2:4'
_A.printA:
    _T11 = *(_T2 + 4)
    parm _T11
    call _PrintInt
    _T12 = "\n"
    parm _T12
    call _PrintString
}

FUNCTION(main) {
memo ''
main:
    _T15 =  call _A_New
    _T14 = _T15
    _T16 = 10
    parm _T14
    parm _T16
    _T17 = *(_T14 + 0)
    _T18 = *(_T17 + 8)
    call _T18
    _T19 = 6
    _T20 = 0
    _T21 = (_T19 < _T20)
    if (_T21 == 0) branch _L13
    _T22 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T22
    call _PrintString
    call _Halt
_L13:
    _T23 = 4
    _T24 = (_T23 * _T19)
    _T25 = (_T23 + _T24)
    parm _T25
    _T26 =  call _Alloc
    *(_T26 + 0) = _T19
    _T27 = 0
    _T26 = (_T26 + _T25)
_L14:
    _T25 = (_T25 - _T23)
    if (_T25 == 0) branch _L15
    _T26 = (_T26 - _T23)
    *(_T26 + 0) = _T27
    branch _L14
_L15:
    _T28 = 4
    _T29 = _T26
    _T30 = (_T19 * _T28)
    _T31 = (_T26 + _T30)
_L16:
    _T32 = (_T29 < _T31)
    if (_T32 == 0) branch _L17
    _T33 =  call _A_New
    _T34 = 8
    _T35 = 4
    _T36 = (_T33 + _T34)
_L18:
    _T37 = (_T36 - _T35)
    _T36 = _T37
    _T38 = (_T34 - _T35)
    _T34 = _T38
    if (_T34 == 0) branch _L19
    _T39 = (_T14 + _T34)
    _T40 = *(_T39 + 0)
    *(_T36 + 0) = _T40
    branch _L18
_L19:
    *(_T29 + 0) = _T36
    _T41 = (_T29 + _T28)
    _T29 = _T41
    branch _L16
_L17:
    _T13 = _T26
    _T42 = 1
    _T43 = *(_T13 - 4)
    _T44 = (_T42 < _T43)
    if (_T44 == 0) branch _L20
    _T45 = 0
    _T46 = (_T42 < _T45)
    if (_T46 == 0) branch _L21
_L20:
    _T47 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T47
    call _PrintString
    call _Halt
_L21:
    _T48 = 4
    _T49 = (_T42 * _T48)
    _T50 = (_T13 + _T49)
    _T51 = *(_T50 + 0)
    _T52 = 15
    parm _T51
    parm _T52
    _T53 = *(_T51 + 0)
    _T54 = *(_T53 + 8)
    call _T54
    _T55 = 0
    _T56 = *(_T13 - 4)
    _T57 = (_T55 < _T56)
    if (_T57 == 0) branch _L22
    _T58 = 0
    _T59 = (_T55 < _T58)
    if (_T59 == 0) branch _L23
_L22:
    _T60 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T60
    call _PrintString
    call _Halt
_L23:
    _T61 = 4
    _T62 = (_T55 * _T61)
    _T63 = (_T13 + _T62)
    _T64 = *(_T63 + 0)
    parm _T64
    _T65 = *(_T64 + 0)
    _T66 = *(_T65 + 12)
    call _T66
    _T67 = 1
    _T68 = *(_T13 - 4)
    _T69 = (_T67 < _T68)
    if (_T69 == 0) branch _L24
    _T70 = 0
    _T71 = (_T67 < _T70)
    if (_T71 == 0) branch _L25
_L24:
    _T72 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T72
    call _PrintString
    call _Halt
_L25:
    _T73 = 4
    _T74 = (_T67 * _T73)
    _T75 = (_T13 + _T74)
    _T76 = *(_T75 + 0)
    parm _T76
    _T77 = *(_T76 + 0)
    _T78 = *(_T77 + 12)
    call _T78
}

